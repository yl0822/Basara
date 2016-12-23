package multiannotation;

import org.springframework.stereotype.Component;

/**
 * Created by long.yl
 * Created in 2016/12/7
 * Created on Basara_multiannotation
 */
@Component("calc")
public class CalcImpl implements Calc {


    @Override
    @AoCache
    @DemoteMethod
    public int add(int x, int y) {
        return x + y;
    }
}
