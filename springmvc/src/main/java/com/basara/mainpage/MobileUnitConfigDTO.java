package com.basara.mainpage;

/**
 * @author long.yl.
 * @Date 2016/6/28
 */
public class MobileUnitConfigDTO extends MobileUnitConfig implements Comparable<MobileUnitConfigDTO> {

    public MobileUnitConfigDTO() {
    }

    public MobileUnitConfigDTO(MobileUnitConfig obj) {
        ReflectUtils.convertObj(this, obj);
    }

    @Override
    public int compareTo(MobileUnitConfigDTO arg0) {
        if (this.getUnitOrder() > arg0.getUnitOrder()) {
            return 1;
        } else if (this.getUnitOrder() < arg0.getUnitOrder()) {
            return -1;
        } else {
            return 0;
        }
    }
}
