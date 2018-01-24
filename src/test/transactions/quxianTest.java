package transactions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testScript.ScreenHot;
import testScript.loadInit;

import java.util.List;

/***
 * 取现
 */
public class quxianTest {

    private loadInit linit;

    private ScreenHot sc=new ScreenHot();

    private AndroidDriver driver;

    private loginTest _loginTest=new loginTest();

    /**
     * 执行 buy manage
     * 快取1元
     */
    @Test
    public void quickManage()throws Exception{
        MobileElement el1 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_finance");
        el1.click();
        Thread.sleep(5000);
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"理财\"]/android.widget.ListView[2]/android.view.View[1]");
        el2.click();
        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"现金宝\"]/android.view.View[10]");
        el3.click();
        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"取现\"]/android.view.View[3]/android.widget.EditText");
        el4.click();
        driver.pressKeyCode(8);
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"取现\"]");
        el5.click();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(119, 908).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(114, 1003).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(109, 1104).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(349, 900).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(352, 1001).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(349, 1114).perform();
        Thread.sleep(5000);
        (new TouchAction(driver)).tap(249, 461).perform();
        Thread.sleep(8000);
        MobileElement el9 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_back");
        el9.click();
        el9.click();


    }

    /**
     * 执行 buy manage
     * 普取1元
     */
    @Test
    public void normalManage()throws Exception{
        MobileElement el0 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_finance");
        el0.click();
        Thread.sleep(5000);
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"理财\"]/android.widget.ListView[2]/android.view.View[1]");
        el1.click();
        Thread.sleep(5000);
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("取现");
        el2.click();
        Thread.sleep(3000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"取现\"]/android.view.View[3]/android.widget.EditText");
        el3.click();
        driver.pressKeyCode(8);
        Thread.sleep(3000);
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("普通取现（当日有收益）");
        el4.click();
        Thread.sleep(3000);
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"取现\"]");
        el5.click();
        Thread.sleep(3000);
        (new TouchAction(driver)).tap(116, 916).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(114, 1011).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(122, 1091).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(360, 916).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(365, 1001).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(363, 1106).perform();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_back");
        el9.click();
        el9.click();
        Thread.sleep(2000);
        MobileElement el10 = (MobileElement) driver.findElementById("com.dfzq.winner:id/text_right");
        el10.click();
        Thread.sleep(2000);
        (new TouchAction(driver)).press(157, 423).moveTo(202,0).waitAction(1000).moveTo(198,0).waitAction(1000).moveTo(0,199).release().perform();
        Thread.sleep(2000);
        el10.click();
        Thread.sleep(2000);
        MobileElement el11 = (MobileElement) driver.findElementById("com.dfzq.winner:id/text_right");
        el10.click();
        Thread.sleep(2000);
        MobileElement el12 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_back");
        el12.click();
        el12.click();
    }

    /**
     * 执行 buy manage
     * 撤单普取
     */
    @Test
    public void cancel()throws Exception{
        MobileElement el1 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_finance");
        el1.click();
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("com.dfzq.winner:id/text_right");
        el2.click();
        Thread.sleep(2000);
        (new TouchAction(driver)).press(157, 423).moveTo(202,0).waitAction(1000).moveTo(198,0).waitAction(1000).moveTo(0,199).release().perform();
        Thread.sleep(2000);
        el2.click();
        Thread.sleep(5000);
        //MobileElement el3 = (MobileElement) driver.findElementById("com.dfzq.winner:id/text_right");
        //el3.click();
        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElement(By.xpath("(//android.view.View[@content-desc='1-18普取现金宝'])[1]"));
        el4.click();
        Thread.sleep(5000);
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("撤单");
        el5.click();
        (new TouchAction(driver)).tap(363, 813).perform();
        Thread.sleep(2000);
        (new TouchAction(driver)).tap(111, 916).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(119, 1019).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(130, 1112).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(363, 897).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(365, 1011).perform();
        Thread.sleep(1000);
        (new TouchAction(driver)).tap(352, 1106).perform();
        Thread.sleep(3000);
        MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("确定");
        el6.click();
        Thread.sleep(1000);
        MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("1.00元已撤单");
        if(el7.getText().equals("1.00元已撤单")){
            System.out.println("撤单成功");
        }

        Thread.sleep(2000);
        MobileElement el12 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_back");
        el12.click();
        el12.click();

    }




    /***
     * 买入案例
     * @throws Exception
     */
  @Test
   public void execbuyTest()throws Exception{
       driver=_loginTest.init(driver);
       Thread.sleep(10000);
       driver.findElementById("com.dfzq.winner:id/item_bottom_mine").click();
       try{
           for(int i=0;i<=10;i++){
               //this.quickManage();
               this.normalManage();
               this.cancel();
           }
       }catch (Exception e){
           e.printStackTrace();
           driver.closeApp();
           execbuyTest();
       }
   }

    /***
     * 买入案例
     * @throws Exception
     */
    @Test
    public void test()throws Exception{
        driver=_loginTest.init(driver);
        Thread.sleep(10000);
        driver.findElementById("com.dfzq.winner:id/item_bottom_mine").click();
        normalManage();
        this.cancel();
    }

}
