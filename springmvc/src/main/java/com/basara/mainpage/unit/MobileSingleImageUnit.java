package com.basara.mainpage.unit;

import com.basara.mainpage.unit.vo.MobileSingleImageItemVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * 图文单元
 */
@JsonInclude(Include.NON_NULL)
public class MobileSingleImageUnit extends MobileBaseUnit {

	// 图片数据列表
	private List<MobileSingleImageItemVO> list;

	public List<MobileSingleImageItemVO> getList() {
		return list;
	}

	public void setList(List<MobileSingleImageItemVO> list) {
		this.list = list;
	}

}
