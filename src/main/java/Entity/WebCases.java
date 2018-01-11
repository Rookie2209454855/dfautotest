package Entity;

import java.io.Serializable;

public class WebCases implements Serializable {


    private Integer id;

    private String name;

    private String context;

    private String turl;

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }

    /**暂用**/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public WebCases() {
        super();
    }
}
