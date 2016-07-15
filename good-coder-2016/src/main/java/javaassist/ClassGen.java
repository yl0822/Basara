package javaassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * Created by Larry .Yang
 * on 16/3/28 14:15
 * Package: parent_PACKAGE_NAME
 */
public class ClassGen {
    public static void main(String[] args) throws Throwable {
        /**
         * 动态插入Coder的code方法
         * */
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.getCtClass("javaassist.Coder");
        CtMethod ctMethod = CtMethod.make("public void code(){}", ctClass);
        ctMethod.insertBefore("System.out.println(\"gen class by javassist ...\");");
        ctClass.addMethod(ctMethod);
        ctClass.writeFile("good-coder-2016/target");
    }
}
