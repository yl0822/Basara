package pattern.decorator;

/**
 * @author long.yl.
 * @Date 2016/6/7
 */
public class Decorator_Third extends Decorator {
    public Decorator_Third(Translator translator) {
        super(translator);
    }

    @Override
    public void trans2Chiness() {
        super.trans2Chiness();
        System.out.println("翻译中文第三步 ... ");
    }

    @Override
    public void tarns2English() {
        super.tarns2English();
        System.out.println("翻译英文第三步 ... ");
    }
}
