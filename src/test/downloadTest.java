import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class downloadTest {

    public static void downloadNet(String uri, String disk, String project) throws MalformedURLException {
        HttpServletResponse response;
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;
        //String links="https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=404a1782eb1190ef1efb94dffe1a9df7/3ac79f3df8dcd1007fde3f4e7e8b4710b9122f1b.jpg";
        try {
            URL url = new URL(uri.trim());
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            String suffix = uri.substring(uri.lastIndexOf("."), uri.length());
            System.out.println(suffix);
            System.out.println(disk.toUpperCase() + "://" + project + "//" + new Random().nextInt() + suffix);
            File file = new File(disk.toUpperCase() + "://" + project);
            if (!file.exists()) {
                file.mkdir();
            }
            FileOutputStream fs = new FileOutputStream(file + "//" + new Random().nextInt() + suffix);
            byte[] buffer = new byte[1204];
            int length;
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    public static void main(String args[]) {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        // 列出所有windows 磁盘
        File[] fs = File.listRoots();
        // 显示磁盘卷标
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fsv.getSystemDisplayName(fs[i]));
            //System.out.print("总大小" + FormetFileSize(fs[i].getTotalSpace()));
            System.out.println("剩余" + FormetFileSize(fs[i].getFreeSpace()));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入盘符：");
        String disk = scanner.nextLine();
        System.out.print("输入文件夹：");
        String project = scanner.nextLine();
        System.out.print("输入链接：");
        String links = scanner.nextLine();
        try {
            downloadNet(links, disk, project);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
