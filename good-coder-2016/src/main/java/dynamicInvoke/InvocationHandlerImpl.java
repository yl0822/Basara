package dynamicInvoke;

import pattern.proxy.Translator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Larry .Yang
 * on 16/3/28 17:24
 * Package: parent_dynamicInvoke
 */
public class InvocationHandlerImpl implements InvocationHandler {

    Translator translator;

    public InvocationHandlerImpl(Translator translator){
        this.translator = translator;
    }

    //InvocationHandler简化了javassist中的代理类生成操作

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里可以完成翻译前置操作...");
        method.invoke(translator, "invoke");
        System.out.println("这里可以完成翻译后置操作...");
        return null;
    }
}
