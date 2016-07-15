package com.basara.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author long.yl.
 * @Date 2016/4/16
 */

/**
 * 声明切面
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 定义切入点
     */
    @Pointcut("execution(* com.basara.aop.*.*(..))")
    private void pointCutMethod() {
    }

    //声明前置通知
    @Before("pointCutMethod()")
    public void doBefore() {
        System.out.println("前置通知（不管方法是否出现异常都执行...）");
    }

    //声明后置通知
    @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
    public void doAfterReturning(String result) {
        System.out.println("后置通知（带返回值的方法正常返回后执行...）");
        System.out.println("---" + result + "---");
    }

    //声明例外通知
    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        System.out.println("例外通知(方法运行出现异常执行...)");
        System.out.println(e.getMessage());
    }

    //声明最终通知
    @After("pointCutMethod()")
    public void doAfter() {
        System.out.println("最终通知（不管方法是否出现异常都执行并早于例外通知执行...）");
    }

    //声明环绕通知
    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入方法---环绕通知（早于前置通知执行...）");
        Object o = pjp.proceed();
        System.out.println("退出方法---环绕通知（早于最终通知执行，如果出现异常不执行...）");
        return o;
    }

}
