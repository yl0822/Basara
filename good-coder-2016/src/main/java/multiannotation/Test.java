package multiannotation;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by long.yl
 * Created in 2016/12/7
 * Created on Basara_multiannotation
 */
public class Test {

    public static void main(String[] args) throws Exception{
        String path = "F:\\Dau.txt";
        File file = new File(path);
//        Writer writer = new BufferedWriter(new FileWriter(file));
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 5000; j++) {
//                writer.write("123456498\n");
//            }
//            writer.flush();
//            System.out.println("round :" + i + "file length : " + file.length());
//        }
//        writer.close();
        List<String> ids = new ArrayList<>();
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                System.out.println(line);
                ids.add(line);
                if (ids.size() > 1000000){
                    System.out.println();
                    ids.clear();
                }
            }
        } finally {
            LineIterator.closeQuietly(it);
        }
        System.out.println(ids.size());
    }
}
