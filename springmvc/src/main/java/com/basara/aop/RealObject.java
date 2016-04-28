package com.basara.aop;

import org.springframework.stereotype.Component;

/**
 * @author long.yl.
 * @Date 2016/4/16
 */
@Component
public class RealObject {
    public final void finalMethodTest(){
        System.out.println("this is a final method.");
    }

    public void normalMethodTest(){
        System.out.println("this is a normal method.");
    }

    public String returnMethodTest(){
        System.out.println("this is a normal method with return type.");
        return "returnMethodTest";
    }

    public void exceptionMethodTest(){
        System.out.println("this is a exception method.");
        throw new IllegalStateException("some exception here!");
    }
}
