package Utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fengtiepeng on 2017/9/18.
 */
public class ErroScreen {


    public  void Screenshot(AndroidDriver driver, String ScreenName)throws IOException {
        //设置时间格式
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd-mm-ss");
        //生成时间戳
        String dateString =formatter.format(new Date());
        String dir_name="F:\\异常图片";
        System.out.println("异常图片目录"+dir_name);
        //由于可能存在异常图片的且当被删除的可能，所以这边先判断目录是否存在
        if(!(new File(dir_name+"\\"+ScreenName+"\\").isDirectory()));
        {
            //判断是否存在该目录
            new File(dir_name+"\\"+ScreenName+"\\").mkdir();
        }
        //调用方法捕捉画面
        File screen=driver.getScreenshotAs(OutputType.FILE);
        //复制文件到指定目录
        //图片最后存放的路径由 目录：dir_name +时间戳+测试套件+测试用例+测试步骤组合生成
        System.out.println("异常图片名称"+dir_name+"\\"+dateString+ScreenName+".jpg");
        FileUtils.copyFile(screen,new File(ScreenName+"\\"+dateString+".jpg"));
    }
}
