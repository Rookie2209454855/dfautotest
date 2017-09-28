package IService;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by fengtiepeng on 2017/9/28.
 */
public interface ExcelUploadService {

    String readExcelFile(MultipartFile file) throws IOException;
}
