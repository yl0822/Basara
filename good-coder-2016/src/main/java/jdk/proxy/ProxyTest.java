package jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author long.yl.
 * @Date 2016/6/2
 */
public class ProxyTest {
    public static void main(String[] args) {
        final Real hello = new RealObject();

        /*
         * proxyHello    : 代理主题角色，代理类的实例
         * IHello        : 抽象主题角色，代理类和被代理类都需要实现的接口，JDK中的动态代理必须针对接口
         * hello         : 真实主题角色，被代理类的实例
         */
        Real proxyHello = (Real) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[] { Real.class }, new InvocationHandler() {

                    /*
                     * @param proxy : 当前代理类的一个实例； 若在invoke()方法中调用proxy的非final方法，将造成无限循环调用.
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object object = null;
                        // 前置的业务逻辑操作
                        System.out.println("---BeforeAdvice");
                        try {
                            // 调用被代理类的方法，传入参数args，得到返回
                            object = method.invoke(hello, args);
                        }catch (Exception e){
                            System.out.println("---ThrowAdvice");
                        }

                        // 后置的业务逻辑操作
                        System.out.println("---AfterAdvice");

                        return object;
//                        System.out.println("---AfterReturningAdvice");
                    }
                });

        proxyHello.execute();
    }
}
