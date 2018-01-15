package tradeTests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import testScript.ScreenHot;
import testScript.loadInit;

/***
 * 委托
 */
public class entrustTest {

    private loadInit linit;

    private ScreenHot sc=new ScreenHot();

    private AndroidDriver driver;

    private tradeTests.loginTest _loginTest=new tradeTests.loginTest();

    /**
     * 执行历史委托操作
     *
     */
    @Test
    public void manage()throws Exception{

        try{
            //click buy
            MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[4]");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[3]");
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementById("com.dfzq.winner:id/begin_date_textview");
            el3.click();
            MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.Button[1]");
            el4.click();
            MobileElement el5 = (MobileElement) driver.findElementById("android:id/button1");
            el5.click();
            Thread.sleep(5000);
            MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout");
            el9.click();
            (new TouchAction(driver)).tap(349, 929).perform();
            MobileElement el10 = (MobileElement) driver.findElementById("com.dfzq.winner:id/left_back_button");
            el10.click();


        }catch (Exception e){
            e.printStackTrace();
            sc.Screenshot(driver,"价格联动erro");
        }


    }

    /**
     * 执行历史成交操作
     *
     */
    @Test
    public void manage1()throws Exception{

        try{
            //click buy
            MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[4]");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[4]");
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementById("com.dfzq.winner:id/begin_date_textview");
            el3.click();
            MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.Button[1]");
            el4.click();
            MobileElement el5 = (MobileElement) driver.findElementById("android:id/button1");
            el5.click();
            Thread.sleep(5000);
            MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout");
            el6.click();
            (new TouchAction(driver)).tap(357, 927).perform();
            MobileElement el7 = (MobileElement) driver.findElementById("com.dfzq.winner:id/left_back_button");
            el7.click();



        }catch (Exception e){
            e.printStackTrace();
            sc.Screenshot(driver,"价格联动erro");
        }


    }


    /***
     * 案例
     * @throws Exception
     */
   @Test
   public void execbuyTest()throws Exception{
       driver=_loginTest.init(driver);
       try{
           for(int i=0;i<=100;i++){
               this.manage();
               driver.findElement(By.id("com.dfzq.winner:id/left_back_button")).click();
               this.manage1();
               driver.findElement(By.id("com.dfzq.winner:id/left_back_button")).click();
           }
       }catch (Exception e){
           e.printStackTrace();
           execbuyTest();
       }

   }


}
