package com.basara.mainpage.unit;

import com.basara.mainpage.unit.vo.MobileKeyPairVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

/**
 * 滚动文本单元
 */
@JsonInclude(Include.NON_NULL)
public class MobileScrollTextUnit extends MobileBaseUnit {

	// 图标Url
	private String icon;

	// 文本列表
	private List<MobileKeyPairVO> textList;

	public List<MobileKeyPairVO> getTextList() {
		return textList;
	}

	public void setTextList(List<MobileKeyPairVO> textList) {
		this.textList = textList;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
