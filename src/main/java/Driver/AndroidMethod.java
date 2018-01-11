package Driver;

import Entity.Pixel;
import Entity.TDevice;
import Utils.ErroScreen;
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
    private ErroScreen erroScree=new ErroScreen();
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
        WebElement element1=null;
        try{
            if("id".equals(type)||"ID".equals(type)){
                element1=driver.findElement(By.id(element.toString()));
            }else if("xpath".equals(type)||"XPATH".equals(type)){
                element1=driver.findElement(By.xpath(element.toString()));
            }else if("txt".equals(type)||"TXT".equals(type)){
                return driver.findElementByAccessibilityId(element.toString());
            }else if("px".equals(type)||"PX".equals(type)){
                String[] xys=element.split(",");
                TouchAction action = new TouchAction(driver);
                action.tap(Integer.parseInt(xys[0]), Integer.parseInt(xys[0])).perform();
            }

        }catch (Exception se){
            se.printStackTrace();
            logger.error("元素筛选失败!");
        }
        return element1;
    }

    /***
     * 点击方法
     * @param webElement
     */
    public void click(WebElement webElement,String path)throws IOException{
        webElement.click();
        erroScree.Screenshot(driver,path);
    }

    /***
     * 输入文本
     * @param webElement
     * @param keys
     */
    public void sendKeys(WebElement webElement,String keys,String path)throws IOException{
        webElement.sendKeys(keys);
        erroScree.Screenshot(driver,path);
    }

    /***
     * 输入数字/英文
     *@param keys
     */
    public void sendKeyEvent(String keys,String path)throws IOException{
        int[] keycodes=convertKeyCode(keys);
        for(int key:keycodes){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                logger.error(e1.getMessage(), e1);
            }
            driver.pressKeyCode(key);
        }
        erroScree.Screenshot(driver,path);
    }

    /****
     * 滑动方法
     */
    public void swap(Pixel pixel,String path) throws IOException{
        this.driver.swipe(pixel.getStartX(), pixel.getStartX(), pixel.getEndX(), pixel.getEndY(), pixel.getDuration());
        erroScree.Screenshot(driver,path);
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
    public void clearText(String path)throws IOException {
        this.driver.pressKeyCode(123);
        for(int i =0;i<30;i++){
            this.driver.pressKeyCode(22);
        }
        for (int i = 0; i < 30; i++) {
            this.driver.pressKeyCode(67);
        }
        erroScree.Screenshot(driver,path);
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

    /**
     * 等待
     * @param times
     */
    public void waitElement(int times)throws Exception{
        Thread.sleep(times);
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
