package com.basara.mainpage.unit;

import com.basara.mainpage.unit.vo.MobilePrdtItemVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * 带更多选项的商品单元
 */
@JsonInclude(Include.NON_NULL)
public class MobilePrdtUnlimitUnit extends MobileBaseUnit {

	// 总数
	private int sum;

	// 一屏水平放置几个item
	private int size;

	// 版面id
	private String layoutIndex;

	// 商品数据列表
	private List<MobilePrdtItemVO> list;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public List<MobilePrdtItemVO> getList() {
		return list;
	}

	public void setList(List<MobilePrdtItemVO> list) {
		this.list = list;
	}

	public String getLayoutIndex() {
		return layoutIndex;
	}

	public void setLayoutIndex(String layoutIndex) {
		this.layoutIndex = layoutIndex;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
