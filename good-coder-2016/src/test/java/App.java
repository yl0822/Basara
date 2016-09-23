import org.junit.experimental.theories.internal.BooleanSupplier;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by long.yl on 2016/7/11.
 */
public class App {

	public static void main(String[] args) {
        System.out.println(new BigDecimal(99));
        System.out.println(new BigDecimal(99.2));
        System.out.println(new BigDecimal(99.00));
        System.out.println(new BigDecimal(99.20));
        System.out.println(new BigDecimal(99.33));
        System.out.println("---------------");
        System.out.println(new BigDecimal(99).doubleValue());
        System.out.println(new BigDecimal(99.2).doubleValue());
        System.out.println(new BigDecimal(99.00).doubleValue());
        System.out.println(new BigDecimal(99.20).doubleValue());
        System.out.println(new BigDecimal(99.33).doubleValue());
    }
}
