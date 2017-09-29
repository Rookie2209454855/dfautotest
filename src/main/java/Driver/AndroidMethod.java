package Driver;

import Entity.Pixel;
import Entity.TDevice;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

/**
 * Created by fengtiepeng on 2017/9/20.
 */
public class AndroidMethod extends init {

    private Log logger = LogFactory.getLog(this.getClass());
    private DesiredCapabilities capabilities;
    private AndroidDriver driver;
    /***
     * 安卓初始化
     * @param tDevice
     * @throws IOException
     */
    public void initAndroid(TDevice tDevice) throws IOException {
        capabilities = new DesiredCapabilities();
        super.init(tDevice,capabilities);
        driver = new AndroidDriver(new URL(tDevice.getUri()), capabilities);
    }

    /***
     * 返回筛选元素
     * @return
     */
    public WebElement resultElement(String element,String type){
        By by=null;
        try{
            if("id".equals(type)||"ID".equals(type)){
                by=By.id(element);
            }else if("xpath".equals(type)||"XPATH".equals(type)){
                by=By.xpath(element);
            }else if("txt".equals(type)||"TXT".equals(type)){
                return driver.findElementByAccessibilityId(element);
            }else if("px".equals(type)||"PX".equals(type)){
                String[] xys=element.split(",");
                TouchAction action = new TouchAction(driver);
                action.tap(Integer.parseInt(xys[0]), Integer.parseInt(xys[0])).perform();
            }
        }catch (Exception se){
            se.printStackTrace();
            logger.error("元素筛选失败!");
        }
        return driver.findElement(by);
    }

    /***
     * 点击方法
     * @param webElement
     */
    public void click(WebElement webElement){
        webElement.click();
    }

    /***
     * 输入文本
     * @param webElement
     * @param keys
     */
    public void sendKeys(WebElement webElement,String keys){
        webElement.sendKeys(keys);
    }

    /***
     * 输入数字/英文
     *@param keys
     */
    public void sendKeyEvent(String keys){
        int[] keycodes=convertKeyCode(keys);
        for(int key:keycodes){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                logger.error(e1.getMessage(), e1);
            }
            driver.sendKeyEvent(key);
        }
    }

    /****
     * 滑动方法
     */
    public void swap(Pixel pixel) {
        this.driver.swipe(pixel.getStartX(), pixel.getStartX(), pixel.getEndX(), pixel.getEndY(), pixel.getDuration());
    }

    /***
     * 返回参数
     * @param text
     * @return
     */
    public boolean result(String text){
        if (this.driver.getPageSource().indexOf(text) != -1) {
            return true;
        }
        return false;
    }

    /***
     * 清空文本
     */
    public void clearText() {
        this.driver.sendKeyEvent(123);
        for(int i =0;i<30;i++){
            this.driver.sendKeyEvent(22);
        }
        for (int i = 0; i < 30; i++) {
            this.driver.sendKeyEvent(67);
        }
    }

    /****
     * 验证文本
     * @param inText
     * @return
     */
    public boolean resultVal(WebElement element,String  inText) {
        if (inText.equals(element.getText()) || inText.equals(element.getAttribute("name"))) {
            return true;
        }
        return false;
    }

    /***
     * 返回元素文本
     * @param element
     * @return
     */
    public String resultText(WebElement element){
        return element.getText();
    }


    /***
     * 关闭并退出app
     */
    public void appQuit(){
        driver.closeApp();
        driver.quit();
    }

    /***
     * 启动app
     */
    public void lanuchApp(){
        driver.launchApp();
    }



}
