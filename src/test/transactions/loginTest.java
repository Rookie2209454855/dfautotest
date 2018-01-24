package transactions;

import Entity.TDevice;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
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
        tDevice.setUdid("127.0.0.1:21503");
        tDevice.setApppath("D:\\DFYJ_SIT_NEW.apk");
        tDevice.setDevice_name("zuk");
        tDevice.setPlatform_name("Android");
        tDevice.setPlatform_version("7.0");
        tDevice.setUri("http://192.168.137.1:4725/wd/hub");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
        driver=linit.init(tDevice,desiredCapabilities);
        Thread.sleep(10000);
        return  driver;
    }




    @Test
    public void test()throws Exception{
        AndroidDriver driver=null;
        driver=this.init(driver);
        for (int i=0;i<1000;i++){
            MobileElement el1 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_mine");
            el1.click();
            Thread.sleep(5000);
            MobileElement el2 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_finance");
            el2.click();
            Thread.sleep(2000);
            MobileElement el3 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_trade");
            el3.click();
            Thread.sleep(2000);
            MobileElement el4 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_custom");
            el4.click();
            Thread.sleep(2000);
            MobileElement el5 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_home");
            el5.click();
        }

    }

}
