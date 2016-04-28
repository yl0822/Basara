package effectivejava;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author long.yl.
 * @Date 2016/4/5
 */
public class ScannerFaker {
    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal(20);
        System.out.println(decimal.toPlainString());
        change(decimal);
        System.out.println(decimal.toPlainString());
    }

    public static void change(BigDecimal decimal){
        decimal = new BigDecimal(50);
    }
}
