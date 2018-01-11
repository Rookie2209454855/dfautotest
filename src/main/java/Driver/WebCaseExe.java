package Driver;

import Entity.WebDevice;
import Entity.WebStep;
import org.junit.Test;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/***
 * 执行web端案例
 */
public class WebCaseExe {

    private WebMethod webMethod;

    public void caseExe(WebDevice webDevice,Integer caseId){
        webMethod=new WebMethod();
        try {
            //加载连接设备的配置
            webMethod.initDriver(webDevice.getDriverUrl(),webDevice.getDriverType());
            //打开待测网页
            webMethod.openUrl(null);
            /**通过caseId查询出来的操作步骤**/
            List<WebStep> steps=new ArrayList<>();
            for(WebStep webStep:steps){
                //筛选操作类型以及使用的方法
                switch (webStep.getMtype()){
                    case 0:
                        webMethod.elementClick(webStep.getElement(),webStep.getEtype());
                        break;
                    case 1:
                        webMethod.elementSend(webStep.getElement(),webStep.getEtype(),webStep.getValue());
                        break;
                    case 2:
                        webStep.setValue(webMethod.resultTxt(webStep.getElement(),webStep.getEtype()));
                        break;
                    case 3:
                        webMethod.elementClear(webStep.getElement(),webStep.getEtype());
                        break;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
