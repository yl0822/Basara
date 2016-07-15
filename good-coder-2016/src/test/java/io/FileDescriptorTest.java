package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author long.yl.
 * @Date 2016/3/18
 */
public class FileDescriptorTest {
    @Test
    public void test() throws Throwable {
        //这里其实文件即使不存在也不会报错
        File file = new File("nofileexists");
        //hint:这里会报错
        //这里为该文件创建一个输入流的时候，就要求该文件必须存在，所以抛出异常
        FileInputStream inputStream = new FileInputStream(file);

        Reader reader = new InputStreamReader(new FileInputStream(new File("")));
        System.out.println(inputStream.getFD());
    }
}
