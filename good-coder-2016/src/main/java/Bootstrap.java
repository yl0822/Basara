import javax.xml.soap.SAAJResult;
import java.io.*;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Larry .Yang
 * on 16/3/25 13:49
 * Package: parent_PACKAGE_NAME
 */
public class Bootstrap {
    private static int i = 0;

    static class Runner1 implements Runnable{
        @Override
        public void run() {
            while (i < 100){
                System.out.println(Thread.currentThread().getName() + ":"+i++);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        String path = "d:\\alibaba.txt";
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
        Writer writer = new BufferedWriter(new FileWriter(file));
        writer.write(1);
        writer.flush();
        Reader reader = new BufferedReader(new FileReader(file));
        int temp;
        if ((temp = reader.read()) != -1){
            System.out.println(temp);
        }
        writer.write(++temp);
        writer.flush();
        writer.close();
    }

    public static String revert(int i){
        if (i == 0){
            return String.valueOf(i);
        }
        int b = 0;
        int sg = 0;
        int temp = 0;
        while (i / (Math.pow(10, temp++)) > 10){
            b++;
        }
        sg = i % 10;
        return String.valueOf((int)(sg * Math.pow(10, b) + Integer.valueOf((revert(i / 10)))));
    }

    private void processFile(File dir){
        File[] fs = dir.listFiles();
        for (File file : fs) {
            if (file.isDirectory()) {
                System.out.println("开始遍历文件夹: " + file.getAbsolutePath());
                try {
                    processFile(file);
                } catch (Exception e) {
                }
            } else {
                if (file.getName().contains("[ZERO动漫下载]")){
                    System.out.println("源文件名称: "+file.getName()+" --> 现文件名称：" + file);
                }
            }
        }
    }
}
