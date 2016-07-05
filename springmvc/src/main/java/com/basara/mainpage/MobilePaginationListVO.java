package com.basara.mainpage;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hzlifangjian on 2016/6/6.
 */
public class MobilePaginationListVO implements Serializable {

	private static final long serialVersionUID = 7324629861039710263L;

	/** 当前页数据 */
	private List<?> list;

	/** 下一页的标识 */
	private String nextId;

	/** 是否有下一页 */
	private int hasNext;

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getNextId() {
		return nextId;
	}

	public void setNextId(String nextId) {
		this.nextId = nextId;
	}

	/**
	 * @return the hasNext
	 */
	public int getHasNext() {
		return hasNext;
	}

	/**
	 * @param hasNext
	 *            the hasNext to set
	 */
	public void setHasNext(int hasNext) {
		this.hasNext = hasNext;
	}
}
