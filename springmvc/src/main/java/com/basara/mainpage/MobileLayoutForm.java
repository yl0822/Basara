package com.basara.mainpage;

/**
 * @author long.yl.
 * @Date 2016/6/28
 */
public class MobileLayoutForm extends BaseMeta {

    /**
     * id
     */
    private long id;

    /**
     * 版面id
     */
    private long layoutId;

    /**
     * 模板数据
     */
    private String formName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(long layoutId) {
        this.layoutId = layoutId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }
}
