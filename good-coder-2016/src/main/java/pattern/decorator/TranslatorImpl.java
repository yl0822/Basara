package pattern.decorator;

/**
 * @author long.yl.
 * @Date 2016/6/7
 */
public class TranslatorImpl implements Translator {
    @Override
    public void trans2Chiness() {
        System.out.println("target string has been trans to Chiness ... ");
    }

    @Override
    public void tarns2English() {
        System.out.println("target string has been trans to English ... ");
    }
}
