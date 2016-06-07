package pattern.decorator;

/**
 * @author long.yl.
 * @Date 2016/6/7
 */
public class App {
    public static void main(String[] args) {
        new Decorator_Third(new Decorator_Second(new Decorator_First(new TranslatorImpl()))).trans2Chiness();
        new Decorator_Third(new Decorator_Second(new Decorator_First(new TranslatorImpl()))).tarns2English();
    }
}
