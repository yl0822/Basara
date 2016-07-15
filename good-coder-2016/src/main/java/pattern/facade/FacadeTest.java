package pattern.facade;

import org.junit.Test;

/**
 * Created by Larry .Yang
 * on 16/3/25 13:59
 * Package: parent_pattern.facade
 */
public class FacadeTest {

    @Test
    public void test() {
        Invoker invoker = new Invoker() {
            @Override
            public void printInfo(Foo foo) {
                System.out.println(foo.getInfo());
            }
        };
        invoker.printInfo(new FooFacade());
    }
}
