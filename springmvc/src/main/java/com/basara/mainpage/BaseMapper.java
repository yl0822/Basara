package com.basara.mainpage;

import java.util.List;

/**
 * Created by hzlifangjian on 2016/6/13.
 */
public interface BaseMapper<T> {
	/**
	 * 插入一条记录
	 * 
	 * @param entity
	 * @return
	 */
	int add(T entity);

	/**
	 * 更新一条记录
	 * 
	 * @param entity
	 * @return
	 */
	int update(T entity);

	/**
	 * 删除一条记录
	 * 
	 * @param id
	 * @return
	 */
	int delete(long id);

	/**
	 * 取出一条记录
	 * 
	 * @param id
	 * @return
	 */
	T findById(long id);

	/**
	 * 取出所有记录
	 * 
	 * @return
	 */
	List<T> findAll();
}
