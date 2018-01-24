package tradeTests;

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
        tDevice.setUri("http://192.168.137.1:4725/wd/hub");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
        driver=linit.init(tDevice,desiredCapabilities);
        Thread.sleep(10000);
        /*交易*/
        WebElement trade=driver.findElement(By.id("com.dfzq.winner:id/item_bottom_trade"));//交易控件
        trade.click();
        Thread.sleep(1000);
        /**查询*/
        WebElement cahxun=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[4]"));
        cahxun.click();
        Thread.sleep(1000);
        /***密码*/
        WebElement epwd=driver.findElement(By.id("com.dfzq.winner:id/secret_edit_text"));
        epwd.sendKeys("123321");
        Thread.sleep(1000);
        /**确定*/
        WebElement confirm=driver.findElement(By.id("com.dfzq.winner:id/confirm_btn"));
        confirm.click();
        Thread.sleep(1000);
        return  driver;
    }

}
