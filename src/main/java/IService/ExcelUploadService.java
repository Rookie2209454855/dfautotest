package IService;

import Entity.Step;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by fengtiepeng on 2017/9/28.
 */
public interface ExcelUploadService {

    List<Step> readExcelFile(MultipartFile file) throws IOException;
}
