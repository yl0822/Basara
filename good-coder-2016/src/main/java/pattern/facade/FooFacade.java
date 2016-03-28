package pattern.facade;

/**
 * Created by Larry .Yang
 * on 16/3/25 14:02
 * Package: parent_pattern.facade
 */
public class FooFacade extends Foo {
    @Override
    public String getInfo() {
        return super.getInfo() + "d";
    }
}
