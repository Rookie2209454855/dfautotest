package Entity;

import java.io.Serializable;

/**
 * Created by fengtiepeng on 2017/9/28.
 */
public class Step implements Serializable {

    private String element;//元素
    private String type;//元素类型
    private String otype;//操作类型
    private String skeys;//输入值
    private String swap;//滑动类型
    private String text;//获取txt值

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Step() {
        super();
    }

    @Override
    public String toString() {
        return "Step{" +
                "element='" + element + '\'' +
                ", type='" + type + '\'' +
                ", otype='" + otype + '\'' +
                ", skeys='" + skeys + '\'' +
                ", swap='" + swap + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
