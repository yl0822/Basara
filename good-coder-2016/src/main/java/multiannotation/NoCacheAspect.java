package multiannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by long.yl
 * Created in 2016/12/7
 * Created on Basara_multiannotation
 */
@Aspect
@Component
public class NoCacheAspect implements Ordered{

//    @Around("@annotation(noCache)")
    public Object doAround(ProceedingJoinPoint point, AoCache aoCache) throws Throwable{
        System.out.println("this is around noCache ... ");
        return point.proceed(point.getArgs());
    }

    @Before("@annotation(aoCache)")
    public void doBefore(AoCache aoCache) throws Throwable{
        System.out.println("this is before noCache ... ");
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
