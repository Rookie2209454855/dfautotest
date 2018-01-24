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
public class duojinTest {

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
        MobileElement el1 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_finance");
        el1.click();

        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("定期");
        el2.click();
        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("招商招利001693 Heading");
        el3.click();
        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("立即买入");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.b[2]");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.dfzq.winner:id/get_verify_code");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.EditText");
        el7.sendKeys("888888");
        MobileElement el8 = (MobileElement) driver.findElementById("com.dfzq.winner:id/login_button");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_dialog_confirm");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementByAccessibilityId("立即买入");
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId("现金宝");
        el11.click();
        (new TouchAction(driver)).tap(291, 824).perform();
        MobileElement el12 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"购买\"]/android.view.View[6]/android.widget.EditText");
        el12.click();
        int[] keycodes=KeysUtils.convertKeyCode("10000");
        for(int key:keycodes){
            driver.pressKeyCode(key);
        }
        MobileElement el13 = (MobileElement) driver.findElementByAccessibilityId("自动买入下一期");
        el13.click();
        (new TouchAction(driver)).tap(305, 832).perform();
        MobileElement el14 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"购买\"]");
        el14.click();
        (new TouchAction(driver)).tap(238, 787).perform();

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
           }
       }catch (Exception e){
           e.printStackTrace();
           driver.closeApp();
           execbuyTest();
       }
   }


}
