package javaassist;

import javassist.*;
import pattern.proxy.Translator;
import pattern.proxy.TranslatorImpl;
import pattern.proxy.TranslatorStaticProxy;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Larry .Yang
 * on 16/3/28 15:24
 * Package: parent_javaassist
 */
public class TranslatorDynamicProxyGen {
    //通过javassist工具,动态生成translator的代理类

    public static void main(String[] args) throws Throwable {
        Translator translatorStaticProxy = new TranslatorStaticProxy(new TranslatorImpl());
        Translator translatorDynamicProxy = genProxy();
        translatorStaticProxy.transToChiness("网易");
        translatorDynamicProxy.transToChiness("阿里");
    }

    public static Translator genProxy() throws NotFoundException, CannotCompileException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
        ClassPool pool = ClassPool.getDefault();

        //生成类用makeClass,修改类用get,其他类型同理
        CtClass ctClass = pool.makeClass("pattern.proxy.TranslatorProxy");

        //设置接口
        CtClass ctInterface = pool.get("pattern.proxy.Translator");
        ctClass.addInterface(ctInterface);

        //设置字段
        CtField ctField = CtField.make("pattern.proxy.Translator translator;", ctClass);
        ctClass.addField(ctField);

        //设置构造器
        CtClass[] ctClasses = new CtClass[]{pool.get("pattern.proxy.TranslatorImpl")};
        CtConstructor ctConstructor = CtNewConstructor.make(ctClasses, null, CtNewConstructor.PASS_NONE, null, null, ctClass);
        ctConstructor.setBody("{this.translator = $1;}");
        ctClass.addConstructor(ctConstructor);

        //设置方法

        //1.设置额外方法
        CtMethod extMethod = CtMethod.make("private void extFuncation(String str){}", ctClass);
        extMethod.setBody("{System.out.println($1 + \" 额外的功能... \");}");
        ctClass.addMethod(extMethod);

        //设置代理方法
        CtMethod chinessProxyMethod = CtMethod.make("public void transToChiness(String str){}", ctClass);
        chinessProxyMethod.setBody("{System.out.println(\"开始动态翻译中文... \");" +
                "translator.transToChiness(\"动态代理\");" +
                "extFuncation(\"谷歌\");"
                + "}");
        ctClass.addMethod(chinessProxyMethod);

        CtMethod englishProxyMethod = CtMethod.make("public void transToEnglish(String str){}", ctClass);
        englishProxyMethod.setBody("{System.out.println(\"开始动态翻译英文... \");" +
                "translator.transToEnglish(\"动态代理\");"
                + "}");
        ctClass.addMethod(englishProxyMethod);

        CtMethod japanessProxyMethod = CtMethod.make("public void transToJapaness(String str){}", ctClass);
        japanessProxyMethod.setBody("{System.out.println(\"开始动态翻译日文... \");" +
                "translator.transToJapaness(\"动态代理\");"
                + "}");
        ctClass.addMethod(japanessProxyMethod);

        //生成字节码文件
        ctClass.writeFile("good-coder-2016/target");

        //动态生成类的实例
        Class clazz = ctClass.toClass();
        Constructor constructor = clazz.getConstructor(pattern.proxy.TranslatorImpl.class);
        Translator translator = (Translator) constructor.newInstance(new TranslatorImpl());

        return translator;
    }
}
