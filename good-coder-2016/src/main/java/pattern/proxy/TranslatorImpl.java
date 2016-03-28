package pattern.proxy;

/**
 * Created by Larry .Yang
 * on 16/3/28 15:15
 * Package: parent_pattern.proxy
 */
public class TranslatorImpl implements Translator {
    @Override
    public void transToChiness(String str) {
        System.out.println("将 " + str + " 翻译成中文...");
    }

    @Override
    public void transToEnglish(String str) {
        System.out.println("将 " + str + " 翻译成英文...");
    }

    @Override
    public void transToJapaness(String str) {
        System.out.println("将 " + str + " 翻译成日文...");
    }
}
