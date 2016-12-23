package multiannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by long.yl
 * Created in 2016/12/7
 * Created on Basara_multiannotation
 */
@Aspect
@Component
public class DemoteAspect implements Ordered {

    @Around("@annotation(demoteMethod)")
    public Object doAround(ProceedingJoinPoint point, DemoteMethod demoteMethod) throws Throwable{
        System.out.println("this is demoteMethod ... ");
        return point.proceed(point.getArgs());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
