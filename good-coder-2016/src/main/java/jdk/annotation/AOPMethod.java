package jdk.annotation;

import java.lang.reflect.Method;

/**
 * @author long.yl.
 * @Date 2016/6/16
 */
public interface AOPMethod {
    void before(Object proxy, Method method, Object[] args);

    void after(Object proxy, Method method, Object[] args);
}