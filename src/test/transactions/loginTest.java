package transactions;

import Entity.TDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import testScript.ScreenHot;
import testScript.loadInit;

public class loginTest {

    private loadInit linit;

    private ScreenHot sc=new ScreenHot();


    //private AndroidDriver driver;

    /***
     * 预加载
     * @throws Exception
     */
    public AndroidDriver init(AndroidDriver driver)throws Exception{
        linit=new loadInit();
        /*加在配置*/
        TDevice tDevice=new TDevice();
        tDevice.setUdid("127.0.0.1:62001");
        tDevice.setApppath("D:\\main-sit-release.apk");
        tDevice.setDevice_name("zuk");
        tDevice.setPlatform_name("Android");
        tDevice.setPlatform_version("7.0");
        tDevice.setUri("http://127.0.0.1:4725/wd/hub");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
        driver=linit.init(tDevice,desiredCapabilities);
        Thread.sleep(10000);
        return  driver;
    }

}
