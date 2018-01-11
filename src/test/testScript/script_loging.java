package testScript;

import Entity.TDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by fengtiepeng on 2017/10/16.
 * 登录脚本
 */
public class script_loging {

    loadInit linit=new loadInit();

    /***
     * 登陆操作
     */
    @Test
    public void login(){
        TDevice tDevice=new TDevice();
        tDevice.setUdid("ee5d6fae");
        tDevice.setApppath("D:\\360极速浏览器下载\\main-sit-release.apk");
        tDevice.setDevice_name("zuk");
        tDevice.setPlatform_name("Android");
        tDevice.setPlatform_version("7.0");
        tDevice.setUri("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
        try{
            AndroidDriver driver=linit.init(tDevice,desiredCapabilities);
            String jump="com.dfzq.winner:id/btn_top_jump";//跳过按钮
            String mine="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout[5]";//"com.dfzq.winner:id/item_bottom_mine";//我的
            String login="com.dfzq.winner:id/home_login_btn1";//登录
            String phoneNo="com.dfzq.winner:id/password";
            String yzm="com.dfzq.winner:id/verify_code";
            String getCode="com.dfzq.winner:id/get_verify_code";
            String jihuo="com.dfzq.winner:id/btn_next";
            Thread.sleep(5000);
            for(int i=0;i<4;i++){
                driver.swipe(1000,1100,200,1100,500);
                Thread.sleep(1000);
                System.out.print(driver.getPageSource());
            }
            driver.findElement(By.id(jump)).click();
            Thread.sleep(1000);
            driver.swipe(500,5,500,1000,500);
            Thread.sleep(1000);
            driver.swipe(500,1727,600,5,570);
            Thread.sleep(2000);
            driver.findElement(By.xpath(mine)).click();
            Thread.sleep(2000);
            driver.findElement(By.id(login)).click();
            Thread.sleep(2000);
            driver.findElement(By.id(phoneNo)).sendKeys("13013130020");
            Thread.sleep(2000);
            driver.findElement(By.id(getCode)).click();
            Thread.sleep(2000);
            driver.findElement(By.id(yzm)).sendKeys("147258");
            Thread.sleep(2000);
            driver.findElement(By.id(jihuo)).click();
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            linit.appQuit();
        }


    }
}
