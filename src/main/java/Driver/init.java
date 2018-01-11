package Driver;

import Entity.TDevice;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengtiepeng on 2017/9/20.
 * 驱动加载类
 */
public abstract class init {

    @Before
    public void init(TDevice tDevice,DesiredCapabilities capabilities) throws IOException {
        capabilities.setCapability(MobileCapabilityType.APP, tDevice.getApppath());
        //设备名称
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                tDevice.getDevice_name());
        // 平台
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
                tDevice.getPlatform_name());
        // 版本
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                tDevice.getPlatform_version());
        capabilities.setCapability("udid", tDevice.getUdid());
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("stopOnRest", true);
        capabilities.setCapability("unicodeKeyboard", true);

    }


    /***
     * 键值转换
     * @param text
     * @return
     */
    public int[] convertKeyCode(String text){
        int[] num_eg;
        /**基本键盘*/
        Map<String,Integer> keycodes=new HashMap<String,Integer>();
        /**加载数字键盘*/
        for(int i=0;i<=9;i++){
            keycodes.put(String.valueOf(i),i+7);
        }
        /**加载英文键盘*/
        String[] e_key=new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        for(int i=0;i<=25;i++){
            keycodes.put(e_key[i],i+29);
        }
        /**获取输入字段*/
        char[] keys=text.toCharArray();
        num_eg=new int[keys.length];
        int i=0;
        for(char key:keys){
            if(keycodes.get(String.valueOf(key).toUpperCase())!=null){
                num_eg[i]=keycodes.get(String.valueOf(key).toUpperCase());
            }
            i=i+1;
        }
        return num_eg;
    }

}
