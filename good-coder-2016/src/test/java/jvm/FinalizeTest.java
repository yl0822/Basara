package jvm;

/**
 * @author long.yl.
 * @Date 2016/3/21
 */
public class FinalizeTest {

    public Object object;

    public static void main(String[] args) {
        FinalizeTest finalizeTest = new FinalizeTest();

//        finalizeTest.object = new FinalizeTest();
        System.gc();
//        while(1==1){
//
//        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("xxx");
        super.finalize();
    }
}
