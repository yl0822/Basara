package threadlocal;

import org.junit.Test;

/**
 * @Author:long.yl
 * @Date:2017/1/23
 * @Package:threadlocal
 */
public class ThreadLocalTest {
    private ThreadLocal<Long> num = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return 3L;
        }
    };

    @Test
    public void test(){
        EndPoint.set();
        System.out.println(num.get());
    }

}