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
public class dingqiTest {

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
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("招商招利001693 Heading");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("立即买入");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("现金宝");
        el5.click();
        (new TouchAction(driver)).tap(283, 836).perform();
        MobileElement el6 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"购买\"]/android.view.View[6]/android.widget.EditText");
        el6.click();
       driver.pressKeyCode(10000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"购买\"]");
        el7.click();
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

