package transactions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import testScript.ScreenHot;
import testScript.loadInit;

/***
 * APP_LC_基金申购
 */
public class shengouTest {

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
        MobileElement el3 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_mine");
        el3.click();
        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_finance");
        el4.click();
        Thread.sleep(5000);
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("基金");
        el5.click();
        Thread.sleep(2000);
        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_fund_buy");
        el7.click();
        Thread.sleep(2000);
        MobileElement el9 = (MobileElement) driver.findElementById("com.dfzq.winner:id/text_money_input");
        el9.sendKeys("1000");
        MobileElement el10 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_buy");
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_dialog_confirm");
        el11.click();
        Thread.sleep(1000);
        MobileElement el12 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_submit");
        el12.click();
        Thread.sleep(1000);
        MobileElement el14=(MobileElement)driver.findElement(By.id("com.dfzq.winner:id/password"));
        el14.click();
        int[] keycodes=KeysUtils.convertKeyCode("147258");
        for(int key:keycodes){
            driver.pressKeyCode(key);
        }
        /*适当性不合规*/
        MobileElement confirm = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_dialog_confirm");
        confirm.click();
        /**返回理财页*/

        MobileElement el1 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_top_back");
        el1.click();
        el1.click();
        el1.click();

    }


    /***
     * 执行申购案例案例
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


    /***
     * 执行申购案例案例
     * @throws Exception
     */
    @Test
    public void getUri()throws Exception{
        driver=_loginTest.init(driver);
        AppiumDriver appiumDriver=driver;
        Thread.sleep(10000);
        MobileElement el4 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_finance");
        el4.click();
        Thread.sleep(5000);
        //driver.navigate().to("www.baidu.com");
        System.out.println(appiumDriver.getCurrentUrl());
    }


}
