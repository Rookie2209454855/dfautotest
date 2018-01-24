package transactions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import testScript.ScreenHot;
import testScript.loadInit;

/***
 * APP_LC_基金认购
 */
public class rengouTest {

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
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.view.View[1]/android.widget.FrameLayout[3]/android.view.View/android.widget.TextView");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_finance");
        el2.click();
        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.b[3]/android.widget.TextView");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_fund_buy");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("com.dfzq.winner:id/text_money_input");
        el9.click();
        el9.sendKeys("1000");
        MobileElement el10 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_buy");
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_dialog_confirm");
        el11.click();
        MobileElement el12 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_submit");
        el12.click();
        MobileElement el13=(MobileElement) driver.findElementById("com.dfzq.winner:id/password");
        el13.click();
        int[] keycodes=KeysUtils.convertKeyCode("147258");
        for(int key:keycodes){
            driver.pressKeyCode(key);
        }
        Thread.sleep(1000);
        driver.pressKeyCode(66);
        Thread.sleep(1000);
        MobileElement el14 = (MobileElement) driver.findElementById("com.dfzq.winner:id/btn_top_back");
        el14.click();
        el14.click();
        el14.click();
        el14.click();
    }


    /***
     * 执行认购购案例案例
     * @throws Exception
     */
  @Test
   public void execTest()throws Exception{
       driver=_loginTest.init(driver);
       Thread.sleep(10000);
       try{
           for(int i=0;i<=10;i++){
               this.manage();
           }
       }catch (Exception e){
           e.printStackTrace();
           driver.closeApp();
           execTest();
       }
   }


}
