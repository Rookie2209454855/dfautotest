package testScript;

import Entity.TDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

/**
 * Created by fengtiepeng on 2017/10/16.
 */
public class loadInit {

     AndroidDriver driver;

    @Before
    public AndroidDriver init(TDevice tDevice, DesiredCapabilities capabilities) throws IOException {
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
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("stopOnRest", false);
        capabilities.setCapability("unicodeKeyboard", true);
       return driver = new AndroidDriver(new URL(tDevice.getUri()), capabilities);
    }


    public void appQuit(){
        driver.closeApp();
        driver.quit();
    }
}
