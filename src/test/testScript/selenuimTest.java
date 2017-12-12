package testScript;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class selenuimTest {

    String uri="http://itest.dfzq.com.cn/html5-trade/trade-index/index.html?oa=0";

    private WebDriver driver;

    @Test
    public void login() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capability= DesiredCapabilities.chrome();
        capability.setJavascriptEnabled(true);
        /***
         * 连接到chromedriver服务
         */
        URL url=new URL("http://localhost:9515");
        driver= new RemoteWebDriver(url,capability);
        driver.get(uri);
        driver.findElement(By.xpath("//*[@id=\'trade-main\']/section/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("mobileTel")).sendKeys("13764682625");
        driver.findElement(By.id("getbcodev4")).click();
        driver.findElement(By.id("mobileTelCode")).sendKeys("888888");
        Thread.sleep(3000);
        driver.findElement(By.id("confirm_btn")).click();
        Thread.sleep(3000);
        driver.findElements(By.partialLinkText("确定"));
        driver.findElement(By.cssSelector("body > div.modal.modal-in > div.modal-buttons > span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\'routers-bindTelephone\']/header/div/i")).click();

        /*driver.findElement(By.id("loginName")).sendKeys("fengtp");
        driver.findElement(By.id("password")).sendKeys("fengtp");
        driver.findElement(By.xpath("//*[@id=\'fm\']/div[4]/div/div[2]/button")).click();*/
    }

}
