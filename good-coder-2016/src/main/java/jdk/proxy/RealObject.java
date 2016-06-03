package jdk.proxy;

/**
 * @author long.yl.
 * @Date 2016/6/2
 */
public class RealObject implements Real {
    @Override
    public void execute(){
        System.out.println("real object do something ... ");
    }
}
