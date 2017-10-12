import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:springConfig/spring-mybatis.xml", "classpath:springConfig/spring-mvc.xml" })
public class BaseTest {

    @Test
    public void test(){
        try{
           /* DeviceService deviceService=new  DeviceServiceImpl();
            deviceService.showAllDevice(new TDevice());*/
            File directory = new File(".");
            String dir_name=directory.getCanonicalPath();
            System.out.println("异常图片目录"+dir_name+"\\");
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
