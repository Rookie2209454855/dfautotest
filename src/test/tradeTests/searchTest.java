package tradeTests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import testScript.ScreenHot;
import testScript.loadInit;

/***
 * 买入
 */
public class searchTest {

    private loadInit linit;

    private ScreenHot sc=new ScreenHot();

    private AndroidDriver driver;

    private tradeTests.loginTest _loginTest=new tradeTests.loginTest();

    /**
     * 执行查询操作
     *
     */
    @Test
    public void manage()throws Exception{

        try{
            //click buy
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[4]")).click();

            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[7]")).click();



            for(int i=2;i<=3;i++){
                StringBuffer sb=new StringBuffer("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView["+i+"]");
                driver.findElement(By.xpath(sb.toString())).click();
            }
            driver.findElement(By.id("com.dfzq.winner:id/left_back_button")).click();

            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[8]")).click();

            driver.findElement(By.id("com.dfzq.winner:id/begin_date_textview")).click();
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.Button[1]")).click();
            driver.findElement(By.id("android:id/button1")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout")).click();
            (new TouchAction(driver)).tap(366, 929).perform();
            driver.findElement(By.id("com.dfzq.winner:id/left_back_button")).click();
        }catch (Exception e){
            e.printStackTrace();
            sc.Screenshot(driver,"价格联动erro");
        }


    }


    /***
     * 买入案例
     * @throws Exception
     */
   @Test
   public void execbuyTest()throws Exception{
       driver=_loginTest.init(driver);
       try{
           for(int i=0;i<=100;i++){
               this.manage();
               driver.findElement(By.id("com.dfzq.winner:id/left_back_button")).click();
           }
       }catch (Exception e){
           e.printStackTrace();
           execbuyTest();
       }

   }


}
