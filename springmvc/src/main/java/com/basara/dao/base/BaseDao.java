package com.basara.dao.base;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
public interface BaseDao<T> {

	int add(T obj);

	T getById(long id);

	int deleteById();

	int update(T obj);
}
