package Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by fengtiepeng on 2017/12/7.
 */
public class WebMethod {

    private WebDriver driver;


    /***
     * 返回web浏览器驱动
     * @return
     * @throws MalformedURLException
     */
    public void initDriver(String uri,Integer type)throws MalformedURLException {
        DesiredCapabilities capability;
        switch (type){
            case 1:
                capability= DesiredCapabilities.chrome();
                break;
            case 2:
                capability= DesiredCapabilities.firefox();
                break;
            case 3:
                capability= DesiredCapabilities.edge();
                break;
            default:
                capability= DesiredCapabilities.firefox();
                break;
        }
        /***
         * 连接到chromedriver服务
         */
        URL url=new URL(uri);
        driver= new RemoteWebDriver(url,capability);
        //return driver;
    }

    public void openUrl(String url){
        driver.get(url);
    }

    /***
     *返回元素By Type
     * @param element
     * @param type
     * @return
     */
   public WebElement resultElement(String element,Integer type){
       WebElement element1=null;
       switch (type){
           case 0:
               element1=driver.findElement(By.id(element));
               break;
           case 1:
               element1=driver.findElement(By.xpath(element));
               break;
           case 2:
               element1=driver.findElement(By.name(element));
               break;
           case 3:
               element1=driver.findElement(By.cssSelector(element));
               break;
       }
       return element1;
   }


    /***
     * 点击选中元素
     */
   public void elementClick(String element,Integer type){
       try {
           WebElement webElement=this.resultElement(element,type);
           webElement.click();
       }catch (Exception e){
           e.printStackTrace();
       }
   }

    /***
     * 输入文本
     */
    public void elementSend(String element,Integer type,String txtValue){
        try {
            WebElement webElement=this.resultElement(element,type);
            webElement.sendKeys(txtValue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /***
     * 清除选中文本
     */
    public void elementClear(String element,Integer type){
        try {
            WebElement webElement=this.resultElement(element,type);
            webElement.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /***
     * 返回选中文本
     */
    public String resultTxt(String element,Integer type){
        String txt=null;
        try {
            WebElement webElement=this.resultElement(element,type);
            txt= webElement.getText();
        }catch (Exception e){
            e.printStackTrace();
        }
        return txt;
    }


    /***
     * 截图并保存指定路径
     * @param savePath
     * @throws IOException
     */
    public void sceerImage(String savePath) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //复制内容到指定文件中
        FileUtils.copyFile(scrFile, new File(savePath));
    }


}
