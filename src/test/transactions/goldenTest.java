package transactions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import testScript.ScreenHot;
import testScript.loadInit;

/***
 * 买入
 */
public class goldenTest {

    private loadInit linit;

    private ScreenHot sc=new ScreenHot();

    private AndroidDriver driver;

    private loginTest _loginTest=new loginTest();

    /**
     * 执行 buy manage
     * 买入数量 为1000股
     */
    @Test
    public void manage()throws Exception{
        //点击理财
        MobileElement el1 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_finance");
        el1.click();
        Thread.sleep(5000);
        //点击现金宝
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"理财\"]/android.widget.ListView[2]/android.view.View[1]");
        el2.click();
        Thread.sleep(5000);
        //点击充值
        MobileElement el3 = (MobileElement) driver.findElementByXPath("(//android.widget.Button[@content-desc=\"充值\"])[1]");
        el3.click();
        Thread.sleep(5000);
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.b[2]");
        el5.click();
        Thread.sleep(5000);
        MobileElement el6 = (MobileElement) driver.findElementById("com.dfzq.winner:id/get_verify_code");
        el6.click();
        Thread.sleep(5000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.EditText");
        el7.sendKeys("888888");
        Thread.sleep(5000);
        MobileElement el8 = (MobileElement) driver.findElementById("com.dfzq.winner:id/login_button");
        el8.click();
        Thread.sleep(2500);
        MobileElement el9 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_dialog_confirm");
        el9.click();
        Thread.sleep(5000);
        el3.click();
        Thread.sleep(5000);
        MobileElement el10 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"充值\"]/android.view.View[4]/android.widget.EditText");
        el10.click();
        int[] keycodes=KeysUtils.convertKeyCode("1000");
        for(int key:keycodes){
            driver.pressKeyCode(key);
        }

        Thread.sleep(2000);
        MobileElement el16 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"充值\"]");
        el16.click();
        Thread.sleep(2000);
        MobileElement el17 = (MobileElement) driver.findElementByAccessibilityId("继续购买");
        el17.click();
        Thread.sleep(2000);
        (new TouchAction(driver)).tap(360, 1010).perform();
        Thread.sleep(2000);
        (new TouchAction(driver)).tap(120, 896).perform();
        Thread.sleep(2000);
        (new TouchAction(driver)).tap(123, 1007).perform();
        Thread.sleep(2000);
        (new TouchAction(driver)).tap(126, 1105).perform();
        Thread.sleep(2000);
        (new TouchAction(driver)).tap(366, 901).perform();
        Thread.sleep(2000);
        (new TouchAction(driver)).tap(360, 1007).perform();
        Thread.sleep(2000);
        (new TouchAction(driver)).tap(360, 1105).perform();
        Thread.sleep(2000);
        driver.findElement(By.id("com.dfzq.winner:id/btn_back")).click();
    }


    /***
     * 买入案例
     * @throws Exception
     */
  @Test
   public void execbuyTest()throws Exception{
       driver=_loginTest.init(driver);
       Thread.sleep(10000);
       try{
           for(int i=0;i<=10;i++){
               this.manage();
               driver.findElement(By.id("com.dfzq.winner:id/btn_back")).click();
           }
       }catch (Exception e){
           e.printStackTrace();
           driver.closeApp();
           execbuyTest();
       }

   }


}
