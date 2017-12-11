package Entity;

/***
 * web驱动属性
 */
public class WebDevice {

    private String driverUrl;

    private Integer driverType;//0=chrome;1=firefox,2=edge;

    private String driverName;


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
