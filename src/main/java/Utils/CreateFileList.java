package Utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by fengtiepeng on 2017/10/12.
 */
public class CreateFileList {


    public static String resultFileList()throws IOException{
        File directory = new File("案例集合");
        String dir_name=directory.getCanonicalPath();
        String dir_name1=dir_name.substring(0,dir_name.indexOf(":")+1)+"\\";
        return dir_name1;
    }
}
