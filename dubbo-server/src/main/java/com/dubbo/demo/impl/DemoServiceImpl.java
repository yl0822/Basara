package com.dubbo.demo.impl;

import com.dubbo.demo.DemoService;

/**
 * @author long.yl.
 * @Date 2016/3/11
 */

public class DemoServiceImpl implements DemoService {
    public String getServiceName() {
        return this.getClass().getSimpleName();
    }

    public String sayHello() {
        return "Hello world, this is my first dubbo remote proceedue calling!";
    }
}
