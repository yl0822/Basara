package dynamicInvoke;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Larry .Yang
 * on 16/3/28 17:46
 * Package: parent_dynamicInvoke
 */
public class ProxyUtil {

    //将根据类的信息,动态生成二进制字节码保存到硬盘中
    public static void genClassByte(Class clazz, String proxyName){
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        String path = clazz.getResource(".").getPath();
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(path + proxyName + ".class");
            fos.write(classFile);
            fos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
