package IService.IServiceImpl;

import Entity.Step;
import IService.ExcelUploadService;
import Utils.ReaderExcel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by fengtiepeng on 2017/9/28.
 * 解析方法
 */
@Service
public class ExcelUploadServiceImpl implements ExcelUploadService {

    public List<Step> readExcelFile(MultipartFile file) throws IOException {
        String result ="";
        //创建处理EXCEL的类
        ReaderExcel readExcel=new ReaderExcel();
        //解析excel，获取上传的事件单
        List<Step> stepsist = readExcel.getExcelInfo(file);
        //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
        //和你具体业务有关,这里不做具体的示范
        if(stepsist != null && !stepsist.isEmpty()){
            //long  startTime=System.currentTimeMillis();
            //System.out.println("fileName："+file.getOriginalFilename());
            String path="F:\\异常图片\\"+file.getOriginalFilename().split("\\.")[0]+"\\";
            if(!(new File(path).isDirectory())){
                new File(path).mkdir();
            }
            File newFile=new File(path+new Date().getTime()+file.getOriginalFilename());
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);
            long  endTime=System.currentTimeMillis();
            //System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
            result = "上传成功";
        }else{
            result = "上传失败";
        }
        return stepsist;
    }
}
