package Entity;

import java.io.Serializable;

/**
 * Created by fengtiepeng on 2017/9/25.
 * 设备机型
 */
public class TDevice implements Serializable {
    private Integer deviceid;//设备标识
    private String apppath;//app路径
    private String device_name;//设备名
    private String platform_name;//系统名
    private String platform_version;//系统版本
    private String udid;//设备udid
    private boolean noReset;//是否重置应用
    private boolean stopOnRest;
    private String uri;//服务地址
    private String autoWebview;//自动切换webview
    private boolean unicodeKeyboard;//使用appium键盘

    public String getApppath() {
        return apppath;
    }

    public void setApppath(String apppath) {
        this.apppath = apppath;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getPlatform_name() {
        return platform_name;
    }

    public void setPlatform_name(String platform_name) {
        this.platform_name = platform_name;
    }

    public String getPlatform_version() {
        return platform_version;
    }

    public void setPlatform_version(String platform_version) {
        this.platform_version = platform_version;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public boolean isNoReset() {
        return noReset;
    }

    public void setNoReset(boolean noReset) {
        this.noReset = noReset;
    }

    public boolean isStopOnRest() {
        return stopOnRest;
    }

    public void setStopOnRest(boolean stopOnRest) {
        this.stopOnRest = stopOnRest;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAutoWebview() {
        return autoWebview;
    }

    public void setAutoWebview(String autoWebview) {
        this.autoWebview = autoWebview;
    }

    public boolean isUnicodeKeyboard() {
        return unicodeKeyboard;
    }

    public void setUnicodeKeyboard(boolean unicodeKeyboard) {
        this.unicodeKeyboard = unicodeKeyboard;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public TDevice() {
        super();
    }

    @Override
    public String toString() {
        return "TDevice{" +
                "deviceid=" + deviceid +
                ", apppath='" + apppath + '\'' +
                ", device_name='" + device_name + '\'' +
                ", platform_name='" + platform_name + '\'' +
                ", platform_version='" + platform_version + '\'' +
                ", udid='" + udid + '\'' +
                ", noReset=" + noReset +
                ", stopOnRest=" + stopOnRest +
                ", uri='" + uri + '\'' +
                ", autoWebview='" + autoWebview + '\'' +
                ", unicodeKeyboard=" + unicodeKeyboard +
                '}';
    }
}
