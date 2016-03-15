package com.basara.enums.base;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
public interface BaseTag<T> {
    /**
     * 获得当前枚举类的int值
     *
     * @return
     */
    int getIntValue();

    /**
     * 根据intValue生成对应的Enum对象
     *
     * @param intValue
     * @return
     */
    T genEnumByIntValue(int intValue);
}
