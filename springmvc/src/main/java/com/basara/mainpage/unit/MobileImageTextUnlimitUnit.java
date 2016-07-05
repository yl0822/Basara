package com.basara.mainpage.unit;

import com.basara.mainpage.unit.vo.MobileSingleImageTextItemVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * 带更多项的图文单元
 */
@JsonInclude(Include.NON_NULL)
public class MobileImageTextUnlimitUnit extends MobileBaseUnit {

	// 总数
	private int sum;

	// 一屏水平放置几个item
	private int size;

	// 版面id
	private String layoutIndex;

	// 图片数据列表
	private List<MobileSingleImageTextItemVO> list;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public List<MobileSingleImageTextItemVO> getList() {
		return list;
	}

	public void setList(List<MobileSingleImageTextItemVO> list) {
		this.list = list;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getLayoutIndex() {
		return layoutIndex;
	}

	public void setLayoutIndex(String layoutIndex) {
		this.layoutIndex = layoutIndex;
	}

}
