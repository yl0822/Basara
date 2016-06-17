package jdk.annotation;

import java.lang.reflect.Method;

/**
 * @author long.yl.
 * @Date 2016/6/16
 */
public class App {
    public static void main(String[] args) {

//        System.out.println("------------------------注解测试----------------------------");
//        DogImp dogImp = (DogImp)AnnoInjection.getBean(new DogImp());
//        System.out.println(dogImp.getName());
//        dogImp.getProperty();

        System.out.println("------------------------AOP测试(单切)----------------------------");
        Annimal dog = AnimalFactory.getAnimal(DogImp.class, new AOPMethod() {
            // 这里写方法执行前的AOP切入方法
            public void before(Object proxy, Method method, Object[] args) {
                if (method.getName().equals("getProperty")) {
                    System.out.println("成功拦截" + method.getName() + "方法,启动");
                }
            }

            // 这里系方法执行后的AOP切入方法
            public void after(Object proxy, Method method, Object[] args) {
                if (method.getName().equals("getProperty"))
                    System.out.println("成功拦截" + method.getName() + "方法,结束");

            }
        });
        dog.say();
//        String name1 = "我的名字是" + dog.getName();
//        System.out.println(name1);
//        dog.setName("二狗子");
//        String name2 = "我的名字是" + dog.getName();
//        System.out.println(name2);
        dog.getProperty();
    }
}
