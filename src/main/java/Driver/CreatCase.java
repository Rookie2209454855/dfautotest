package Driver;

import Entity.Pixel;
import Entity.Step;
import Entity.TDevice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

/**
 * Created by fengtiepeng on 2017/9/29.
 * 生成appium脚本
 */
public class CreatCase {
    private AndroidMethod androidMethod=new AndroidMethod();

    private Log logger= LogFactory.getLog(this.getClass());

    public void cases(TDevice device, List<Step> steps,String path) throws IOException {
        /**初始化设备*/
        try{
            androidMethod.initAndroid(device);
            if(steps.size()>0){
                for(Step step:steps){
                    if(step.getOtype().equals("wait")){
                        androidMethod.waitElement(Integer.parseInt(step.getSkeys()));
                    }else {
                        WebElement webElement=androidMethod.resultElement(step.getElement(),step.getType());
                        if(step.getOtype().toLowerCase().equals("click")){
                            androidMethod.click(webElement,path);
                        }else if(step.getOtype().toLowerCase().equals("send")){
                            androidMethod.sendKeys(webElement,step.getSkeys(),path);
                        }else if(step.getOtype().toLowerCase().equals("swap")){
                            Pixel pixel=this.jxSwapPx(step.getSwap());
                            androidMethod.swap(pixel,path);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }finally {
            androidMethod.appQuit();
        }
    }

    /***
     * 计算像素
     * @param px
     * @return
     */
    public Pixel jxSwapPx(String px){
        String[] pxs=px.split(",");
        Pixel pixel=new Pixel();
        pixel.setStartX(Integer.parseInt(pxs[0]));
        pixel.setStartY(Integer.parseInt(pxs[1]));
        pixel.setEndX(Integer.parseInt(pxs[3]));
        pixel.setEndY(Integer.parseInt(pxs[4]));
        pixel.setDuration(1000);
        return pixel;
    }


}
