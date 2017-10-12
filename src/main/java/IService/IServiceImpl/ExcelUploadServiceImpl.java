package IService.IServiceImpl;

import Entity.Step;
import IService.ExcelUploadService;
import Utils.CreateFileList;
import Utils.ReaderExcel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
        if(stepsist != null && !stepsist.isEmpty()){
            String path= CreateFileList.resultFileList()+file.getOriginalFilename().split("\\.")[0]+"\\";
            if(!(new File(path).isDirectory())){
                new File(path).mkdir();
            }
            File newFile=new File(path+file.getOriginalFilename());
            if(newFile.exists()){
                newFile.delete();
            }
            file.transferTo(newFile);
            long  endTime=System.currentTimeMillis();
            result = "上传成功";
        }else{
            result = "上传失败";
        }
        return stepsist;
    }
}
