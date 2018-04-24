package tradeTests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import testScript.ScreenHot;
import testScript.loadInit;

/***
 * 买入
 */
public class buyTest {

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


        //click buy
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[1]")).click();

        //查看股东选择
        //driver.findElement(By.id("com.dfzq.winner:id/account_sp")).click();

        //输入股票代码
        driver.findElement(By.id("com.dfzq.winner:id/code_et")).click();
        driver.tap(1,212,1208,200);
        Thread.sleep(500);
        driver.tap(1,212,1208,200);
        Thread.sleep(500);
        driver.tap(1,357,1208,200);
        Thread.sleep(500);
        driver.tap(1,218,865,200);
        Thread.sleep(1000);
        //查看价格联动
        String price=driver.findElement(By.id("com.dfzq.winner:id/price_et")).getText();
        if(price.equals("")){
            sc.Screenshot(driver,"价格联动erro");
        }
        System.out.println(price);

        //price +
        driver.findElement(By.id("com.dfzq.winner:id/price_add")).click();

        //price -
        driver.findElement(By.id("com.dfzq.winner:id/price_sub")).click();

        //数量变化
        String enable_tv=driver.findElement(By.id("com.dfzq.winner:id/enable_tv")).getText();
        System.out.println(enable_tv);
        //购买1000股
        driver.findElement(By.id("com.dfzq.winner:id/amount_et")).sendKeys("1000");

        //确认买入
        driver.findElement(By.id("com.dfzq.winner:id/trade_ok_btn")).click();

        //弹出信息
        String alert_message=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
        System.out.println(alert_message);

        //再次确认
        driver.findElement(By.id("android:id/button1")).click();

        //购买u成功提示
        String message=driver.findElement(By.id("android:id/message")).getText();
        System.out.println(message);

        //确认
        driver.findElement(By.id("android:id/button1")).click();
   }


    /***
     * 买入案例
     * @throws Exception
     */
   @Test
   public void execbuyTest()throws Exception{
       driver=_loginTest.init(driver);
       for(int i=0;i<=10;i++){
           try{

                   this.manage();
                   driver.findElement(By.id("com.dfzq.winner:id/left_back_button")).click();
           }catch (Exception e){
               e.printStackTrace();
               sc.Screenshot(driver,"交易-买入Erro");
               driver=_loginTest.init(driver);
           }
       }

   }


}
