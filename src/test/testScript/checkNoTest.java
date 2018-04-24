package testScript;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;
import transactions.loginTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class checkNoTest {

    private loadInit linit;

    private ScreenHot sc=new ScreenHot();

    private AndroidDriver driver;

    private loginTest _loginTest=new loginTest();
    private String[] lgoinNoS=new String[]{"00148829","00148830","00148831","00148832","00148833"};

    private List<String> lines=new ArrayList<String>();

    public void testAccount()throws Exception{

        Thread.sleep(1000);
        MobileElement eltitle_text = (MobileElement) driver.findElementById("com.dfzq.winner:id/title_text");
        eltitle_text.click();
        /**获取登陆账号列表*/
        Thread.sleep(2000);

        for(int i=1;i<=5;i++){
            StringBuffer stringBuffer=new StringBuffer("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[");
            stringBuffer.append(i+"]/android.widget.TextView[3]");
            try{
                String loginNo=driver.findElementByXPath(stringBuffer.toString()).getText();
                System.out.println(loginNo);
                if(lgoinNoS[i-1].equals(loginNo)){
                    lines.add("账号"+lgoinNoS[i-1]+"存在，验证成功!");
                }
            }catch (Exception e){
                lines.add("账号"+lgoinNoS[i-1]+"不存在！");
                sc.Screenshot(driver,"多登陆账号验证\\异常图片");
            }
        }
        lines.add("--------------------------------------------------------------");
        MobileElement close_dialog = (MobileElement) driver.findElementById("com.dfzq.winner:id/close_dialog");
        close_dialog.click();
        MobileElement left_back_button = (MobileElement) driver.findElementById("com.dfzq.winner:id/left_back_button");
        left_back_button.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[1]");
        el2.click();
    }


    public void firstLogin()throws Exception{
        driver=_loginTest.init(driver);
        Thread.sleep(10000);
        MobileElement el1 = (MobileElement) driver.findElementById("com.dfzq.winner:id/item_bottom_trade");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[1]");
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementById("com.dfzq.winner:id/secret_edit_text");
        el3.sendKeys("147258");
        MobileElement el4 = (MobileElement) driver.findElementById("com.dfzq.winner:id/confirm_btn");
        el4.click();
        Thread.sleep(2000);
    }
    /***
     * 执行资金账号验证
     * @throws Exception
     */
    @Test
    public void Test()throws Exception{
        try{
            this.firstLogin();
            for(int i=0;i<=1000;i++){
                try{
                    this.testAccount();
                }catch (WebDriverException s){
                    driver.closeApp();
                    this.firstLogin();
                }
            }
            FileUtils.writeLines(new File("D:\\多登陆账号验证\\执行状态.txt"),lines,true);
        }catch (Exception e){
            driver=_loginTest.init(driver);
            driver.closeApp();
            driver.quit();
            Test();
        }

    }
}
