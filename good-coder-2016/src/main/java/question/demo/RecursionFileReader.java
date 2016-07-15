package question.demo;

import java.io.*;

/**
 * @author long.yl.
 * @Date 2016/6/21
 */
public class RecursionFileReader {
    public static void readFile(File file) {
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                readFile(file1);
            }
        } else {
            System.out.println("Opt file " + file.getName());
        }
    }

    public static void main(String[] args) throws Exception {
        Reader reader = new InputStreamReader(new FileInputStream(new File("d:\\config")));
        Reader reader1 = new FileReader(new File(""));

        Writer writer = new OutputStreamWriter(new FileOutputStream(new File("d:\\")));
        Writer writer1 = new FileWriter(new File(""));

        RecursionFileReader.readFile(new File("d:\\config"));
    }
}
