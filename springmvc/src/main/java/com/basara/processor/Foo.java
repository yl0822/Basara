package com.basara.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author long.yl.
 * @Date 2016/3/29
 */
@Component
public class Foo {

    @Autowired
    Bar bar;

//    public Bar getBar() {
//        return bar;
//    }
//
//    public void setBar(Bar bar) {
//        this.bar = bar;
//    }

    public void service() {
        bar.doPrint();
    }
}
