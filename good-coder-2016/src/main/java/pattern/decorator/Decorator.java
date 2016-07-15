package pattern.decorator;

/**
 * @author long.yl.
 * @Date 2016/6/7
 */
public class Decorator implements Translator {

    private Translator translator;

    public Decorator(Translator translator) {
        this.translator = translator;
    }

    @Override
    public void trans2Chiness() {
        translator.trans2Chiness();
    }

    @Override
    public void tarns2English() {
        translator.tarns2English();
    }
}
