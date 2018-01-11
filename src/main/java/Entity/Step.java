package Entity;

import java.io.Serializable;

/**
 * Created by fengtiepeng on 2017/9/28.
 */
public class Step implements Serializable {

    private Integer id;
    private String element;//元素
    private String etype;//元素类型
    private String otype;//操作类型
    private String skeys;//输入值
    private String swap;//滑动类型
    private String text;//获取txt值
    private Integer cId;//案例ID

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getOtype() {
        return otype;
    }

    public void setOtype(String otype) {
        this.otype = otype;
    }

    public String getSkeys() {
        return skeys;
    }

    public void setSkeys(String skeys) {
        this.skeys = skeys;
    }

    public String getSwap() {
        return swap;
    }

    public void setSwap(String swap) {
        this.swap = swap;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public Step() {
        super();
    }

    @Override
    public String toString() {
        return "Step{" +
                "element='" + element + '\'' +
                ", type='" + etype + '\'' +
                ", otype='" + otype + '\'' +
                ", skeys='" + skeys + '\'' +
                ", swap='" + swap + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
