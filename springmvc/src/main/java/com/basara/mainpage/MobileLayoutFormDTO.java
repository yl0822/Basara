package com.basara.mainpage;

/**
 * @author long.yl.
 * @Date 2016/6/28
 */
public class MobileLayoutFormDTO extends MobileLayoutForm {

    public MobileLayoutFormDTO() {
    }

    public MobileLayoutFormDTO(MobileLayoutForm obj) {
        ReflectUtils.convertObj(this, obj);
    }

}
