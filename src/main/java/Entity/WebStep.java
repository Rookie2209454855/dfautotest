package Entity;

import java.io.Serializable;

/***
 * web部分自动化实体
 */
public class WebStep implements Serializable {

    private String element;//元素名
    private Integer mtype;//操作类型
    private Integer etype;
    private String value;//返回或输入值
    private Integer index;//序号
    private Integer caseId;//归属案例

    public WebStep(String element, Integer mtype, Integer etype, String value, Integer index, Integer caseId) {
        this.element = element;
        this.mtype = mtype;
        this.etype = etype;
        this.value = value;
        this.index = index;
        this.caseId = caseId;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public Integer getEtype() {
        return etype;
    }

    public void setEtype(Integer etype) {
        this.etype = etype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public WebStep() {
        super();
    }
}
