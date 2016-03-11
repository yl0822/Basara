package provider.impl;

import org.springframework.stereotype.Service;
import provider.DemoService;

/**
 * @author long.yl.
 * @Date 2016/3/11
 */

@Service("demoService")
public class DemoServiceImpl implements DemoService {
    public String getServiceName() {
        return this.getClass().getSimpleName();
    }

    public void sayHello() {
        System.out.println("Hello world, this is my first dubbo remote proceedue calling!");
    }
}
