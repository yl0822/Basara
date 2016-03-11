import org.springframework.beans.factory.annotation.Autowired;
import provider.DemoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author long.yl.
 */
public class BootStrap {

    @Autowired
    DemoService demoService;

    public static void main(String[] args) {
        BootStrap strap = new BootStrap();
        strap.doSomething();
    }

    public void doSomething(){
        demoService.sayHello();
    }
}
