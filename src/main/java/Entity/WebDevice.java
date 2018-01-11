package Entity;

import java.io.Serializable;

/***
 * web驱动属性
 */
public class WebDevice implements Serializable {

    private String driverUrl;//连接地址

    private Integer driverType;//0=chrome;1=firefox,2=edge;

    private String driverName;//驱动名称

    private String context;//备注

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDriverUrl() {
        return driverUrl;
    }

    public void setDriverUrl(String driverUrl) {
        this.driverUrl = driverUrl;
    }

    public Integer getDriverType() {
        return driverType;
    }

    public void setDriverType(Integer driverType) {
        this.driverType = driverType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public WebDevice() {
        super();
    }
}
