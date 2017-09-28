package IService.IServiceImpl;

import Entity.Step;
import IService.ExcelUploadService;
import Utils.ReaderExcel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by fengtiepeng on 2017/9/28.
 */
@Service
public class ExcelUploadServiceImpl implements ExcelUploadService {

    public String readExcelFile(MultipartFile file) {
        String result ="";
        //创建处理EXCEL的类
        ReaderExcel readExcel=new ReaderExcel();
        //解析excel，获取上传的事件单
        List<Step> stepsist = readExcel.getExcelInfo(file);
        //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
        //和你具体业务有关,这里不做具体的示范
        if(stepsist != null && !stepsist.isEmpty()){
            result = "上传成功";
        }else{
            result = "上传失败";
        }
        return result;
    }
}
