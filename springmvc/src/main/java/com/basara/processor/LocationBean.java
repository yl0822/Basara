package com.basara.processor;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.lang.reflect.Proxy;

/**
 * Created by Larry .Yang
 * on 16/3/25 16:36
 * Package: parent_com.basara.processor
 */
@Component
public class LocationBean  {
    @InitBinder
    public void initBinder(){
        System.out.println("initBinder");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.printf("postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }

    public void doPrint(){
        System.out.println("Location Bean is initialized!");
    }
}
