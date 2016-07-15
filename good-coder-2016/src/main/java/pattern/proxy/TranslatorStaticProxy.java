package pattern.proxy;

/**
 * Created by Larry .Yang
 * on 16/3/28 15:16
 * Package: parent_pattern.proxy
 */
public class TranslatorStaticProxy implements Translator {

    //这里是普通的代理模式
    Translator translator;

    public TranslatorStaticProxy(Translator translator) {
        this.translator = translator;
    }

    @Override
    public void transToChiness(String str) {
        System.out.println("开始静态翻译中文...");
        extFuncation("谷歌");
        translator.transToChiness(str);
    }

    @Override
    public void transToEnglish(String str) {
        System.out.println("开始静态翻译英文...");
        translator.transToEnglish(str);
    }

    @Override
    public void transToJapaness(String str) {
        System.out.println("开始静态翻译日文...");
        translator.transToJapaness(str);
    }

    private void extFuncation(String str) {
        System.out.println(str + " 额外的功能...");
    }
}
