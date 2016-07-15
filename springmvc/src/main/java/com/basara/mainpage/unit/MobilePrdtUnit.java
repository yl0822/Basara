package com.basara.mainpage.unit;

import com.basara.mainpage.unit.vo.MobilePrdtItemVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * 商品单元
 */
@JsonInclude(Include.NON_NULL)
public class MobilePrdtUnit extends MobileBaseUnit {

    // 商品数据列表
    private List<MobilePrdtItemVO> list;

    public List<MobilePrdtItemVO> getList() {
        return list;
    }

    public void setList(List<MobilePrdtItemVO> list) {
        this.list = list;
    }

}
