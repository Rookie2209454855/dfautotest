package tradeTests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import testScript.ScreenHot;
import testScript.loadInit;

/***
 * 当日委托
 */
public class entrustmentTest {

    private loadInit linit;

    private ScreenHot sc=new ScreenHot();

    private AndroidDriver driver;

    private loginTest _loginTest=new loginTest();

    /**
     * 执行查询操作
     *
     */
    @Test
    public void manage()throws Exception{

        try{
            //click buy
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[4]")).click();

            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[1]")).click();

            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout")).click();

            (new TouchAction(driver)).tap(366, 929).perform();

            driver.findElement(By.id("com.dfzq.winner:id/left_back_button")).click();

            /**当日成交部分**/


            try{
                driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[2]")).click();

                //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView"));

                driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout")).click();

                (new TouchAction(driver)).tap(366, 929).perform();

                driver.findElement(By.id("com.dfzq.winner:id/left_back_button")).click();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("无记录");
            }

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
