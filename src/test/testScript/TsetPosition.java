package testScript;

import Entity.TDevice;
import Utils.CreateFileList;
import Utils.ErroScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TsetPosition {
    private loadInit linit;


    @Test
    public void checkPosition()throws Exception{
        linit=new loadInit();
        /*加在配置*/
        TDevice tDevice=new TDevice();
        tDevice.setUdid("127.0.0.1:62001");
        tDevice.setApppath("D:\\360极速浏览器下载\\main-sit-release.apk");
        tDevice.setDevice_name("zuk");
        tDevice.setPlatform_name("Android");
        tDevice.setPlatform_version("7.0");
        tDevice.setUri("http://127.0.0.1:4725/wd/hub");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
        AndroidDriver driver=linit.init(tDevice,desiredCapabilities);
        Thread.sleep(10000);
        /*交易*/
        WebElement trade=driver.findElement(By.id("com.dfzq.winner:id/item_bottom_trade"));//交易控件
        trade.click();
        Thread.sleep(1000);
        /**持仓*/
        WebElement chicang=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[7]"));
        chicang.click();
        Thread.sleep(1000);
        /***密码*/
        WebElement epwd=driver.findElement(By.id("com.dfzq.winner:id/secret_edit_text"));
        epwd.sendKeys("963852");
        Thread.sleep(1000);
        /**确定*/
        WebElement confirm=driver.findElement(By.id("com.dfzq.winner:id/confirm_btn"));
        confirm.click();
        chicang.click();
        Thread.sleep(1000);
        /**验证文本*/
        try {
            WebElement titleText = driver.findElement(By.id("com.dfzq.winner:id/trade_list_title_1"));
            String titleValue = "市场类别代码";
            String resultValue = titleText.getText().replaceAll("\r|\n", "");
            /**列表*/
            for(int i=1;i<=5;i++){
                StringBuffer sb=new StringBuffer("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[");
                sb.append(i+"]");
                System.out.println(sb.toString());
                WebElement element=driver.findElement(By.xpath(sb.toString()));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("出错！");
            this.Screenshot(driver,"持仓异常截图");

        }
    }


    /***
     *
     * @param driver
     * @param ScreenName
     * @throws IOException
     */
    public  void Screenshot(AndroidDriver driver, String ScreenName)throws IOException {
        //设置时间格式
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd-mm-ss");
        //生成时间戳
        String dateString =formatter.format(new Date());
        String dir_name="d:\\";
        System.out.println("异常图片目录:"+dir_name);
        //由于可能存在异常图片的且当被删除的可能，所以这边先判断目录是否存在
        if(!(new File(dir_name+"\\"+ScreenName+"\\").isDirectory()));
        {
            //判断是否存在该目录
            new File(dir_name+"\\"+ScreenName+"\\").mkdir();
        }
        //调用方法捕捉画面
        File screen=driver.getScreenshotAs(OutputType.FILE);
        //复制文件到指定目录
        //图片最后存放的路径由 目录：dir_name +时间戳+测试套件+测试用例+测试步骤组合生成
        System.out.println("异常图片名称"+dir_name+"\\"+dateString+ScreenName+".jpg");
        FileUtils.copyFile(screen,new File(dir_name+"\\"+ScreenName+"\\"+dateString+".jpg"));
    }


    @Test
    public void execPosition(){
        try {
            List<String> lines=new ArrayList<String>();
            for(int i=0;i<=1000;i++){
                try{
                    this.checkPosition();
                    lines.add("执行成功低"+i+"次");
                    System.out.println();
                }catch (Exception e){
                    e.printStackTrace();
                    lines.add("执行失败低s" +
                            "c"+i+"次");
                }
            }
            FileUtils.writeLines(new File("D:\\持仓异常截图\\执行状态.txt"),lines,true);
        }catch (IOException io){
            io.printStackTrace();
        }

    }
}
