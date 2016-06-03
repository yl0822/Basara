package spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author long.yl.
 * @Date 2016/6/2
 */
@Aspect
public class StdAspect {

    @Before("execution(* spring.*.*(..))")
    public void cutBefore(){
        System.out.println("before target method invoke ... ");
    }
}
