package testScript;

import Entity.TDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/****
 * 查询
 */
public class TestSearch {


    private loadInit linit;

    private ScreenHot sc=new ScreenHot();

    private  AndroidDriver driver;

    /***
     * 预加载
     * @throws Exception
     */
    private void init()throws Exception{
        linit=new loadInit();
        /*加在配置*/
        TDevice tDevice=new TDevice();
        tDevice.setUdid("127.0.0.1:62001");
        tDevice.setApppath("D:\\main-sit-release.apk");
        tDevice.setDevice_name("zuk");
        tDevice.setPlatform_name("Android");
        tDevice.setPlatform_version("7.0");
        tDevice.setUri("http://127.0.0.1:4725/wd/hub");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
        driver=linit.init(tDevice,desiredCapabilities);
        Thread.sleep(10000);
        /*交易*/
        WebElement trade=driver.findElement(By.id("com.dfzq.winner:id/item_bottom_trade"));//交易控件
        trade.click();
        Thread.sleep(1000);
        /**查询*/
        WebElement cahxun=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[4]"));
        cahxun.click();
        Thread.sleep(1000);
        /***密码*/
        WebElement epwd=driver.findElement(By.id("com.dfzq.winner:id/secret_edit_text"));
        epwd.sendKeys("123321");
        Thread.sleep(1000);
        /**确定*/
        WebElement confirm=driver.findElement(By.id("com.dfzq.winner:id/confirm_btn"));
        confirm.click();
        cahxun.click();
        Thread.sleep(1000);
    }

    /***
     * 历史成交
     * @throws Exception
     */
    private void history()throws Exception{

        WebElement histryElement=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[4]"));
        //WebElement zjls=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[8]"));
        histryElement.click();
       /* driver.findElement(By.id("com.dfzq.winner:id/begin_date_textview")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.Button[1]")).click();
        driver.findElement(By.id("android:id/button1")).click();*/
        String ils="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[";
        this.checkPosition("名称代码","com.dfzq.winner:id/trade_list_title_2",ils,5);
    }

    /***
     * 资金流水成交
     * @throws Exception
     */
    private void trade()throws Exception{
        //WebElement histryElement=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[4]"));
        WebElement zjls=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[8]"));
        zjls.click();
       /* driver.findElement(By.id("com.dfzq.winner:id/begin_date_textview")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.Button[1]")).click();
        driver.findElement(By.id("android:id/button1")).click();*/
        String ils="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[";
        this.checkPosition("发生额业务","com.dfzq.winner:id/trade_list_title_2",ils,4);
    }

    public void checkPosition(String titleValue,String eleValue,String ilis,int count)throws Exception{
        /**验证文本*/
        try {
            Thread.sleep(1000);
            WebElement titleText = driver.findElement(By.id(eleValue));
            String resultValue = titleText.getText().replaceAll("\r|\n", "");
            System.out.println(resultValue);
            if(!titleValue.equals(resultValue)){
                sc.Screenshot(driver,"持仓异常截图");
            }
            /**列表*/
            for(int i=1;i<=count;i++){
                StringBuffer sb=new StringBuffer(ilis);
                sb.append(i+"]");
                System.out.println(sb.toString());
                WebElement element=driver.findElement(By.xpath(sb.toString()));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("出错！");
            sc.Screenshot(driver,"持仓异常截图");
        }
    }


    @Test
    public void execPosition(){
        try {
            this.init();
            List<String> lines=new ArrayList<String>();
            for(int i=0;i<=1000;i++){
                try{
                    this.history();
                    driver.findElement(By.id("com.dfzq.winner:id/left_back_button")).click();
                    this.trade();
                    driver.findElement(By.id("com.dfzq.winner:id/left_back_button")).click();
                    lines.add("执行成功低"+i+"次");
                    System.out.println();
                }catch (Exception e){
                    e.printStackTrace();
                    lines.add("执行失败低s" +
                            "c"+i+"次");
                }
            }
            FileUtils.writeLines(new File("D:\\持仓异常截图\\执行状态.txt"),lines,true);
        }catch (Exception io){
            io.printStackTrace();
            linit.appQuit();
            this.execPosition();
        }
    }
}
