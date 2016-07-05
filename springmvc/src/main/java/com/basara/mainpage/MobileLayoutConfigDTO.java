package com.basara.mainpage;

import java.util.List;

/**
 * @author long.yl.
 * @Date 2016/6/28
 */
public class MobileLayoutConfigDTO extends MobileLayoutConfig implements Comparable<MobileLayoutConfigDTO> {

    private List<MobileUnitConfigDTO> unitList = null;

    private MobileLayoutForm layoutForm;

    private int categoryOrder;

    public MobileLayoutConfigDTO() {
    }

    public MobileLayoutConfigDTO(MobileLayoutConfig obj) {
        ReflectUtils.convertObj(this, obj);
    }

    public List<MobileUnitConfigDTO> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<MobileUnitConfigDTO> unitList) {
        this.unitList = unitList;
    }

    public MobileLayoutForm getLayoutForm() {
        return layoutForm;
    }

    public void setLayoutForm(MobileLayoutForm layoutForm) {
        this.layoutForm = layoutForm;
    }

    public int getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(int categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    @Override
    public int compareTo(MobileLayoutConfigDTO arg0) {
        if (this.getLayoutOrder() > arg0.getLayoutOrder()) {
            return 1;
        } else if (this.getLayoutOrder() < arg0.getLayoutOrder()) {
            return -1;
        } else {
            return 0;
        }
    }
}
