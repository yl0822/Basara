import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Larry .Yang
 * on 16/3/25 13:49
 * Package: parent_PACKAGE_NAME
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\long.yl\\Desktop\\aaa");
        File file2 = new File("F:\\git\\mainserver\\target\\Musician-1.0.0\\WEB-INF\\lib");
        System.out.println("jar file length : " + file2.listFiles().length);
        LineIterator it = null;
        try {
            it = FileUtils.lineIterator(file, "UTF-8");
            List<String> list = new ArrayList<>();
            while (it.hasNext()) {
                String line = it.nextLine();
                list.add(line);
            }
            List<String> newlist = new ArrayList<>(list);
            System.out.println("before ----------- : size: " +newlist.size());
            for (String s : newlist) {
                System.out.println(s);
            }
            int count = 0;
            for (String line : list) {
                for (File file1 : file2.listFiles()) {
                    String filename = file1.getName().substring(0, file1.getName().lastIndexOf("."));
                    if (line.contains(filename)){
                        System.out.println("jar file name : "+ filename + "------------ maven file name : " + line);
                        newlist.remove(line);
                        count++;
                        break;
                    }
                }
            }
            System.out.println("count: "+count );
            System.out.println("after ----------- :: size: " +newlist.size());
            for (String s : newlist) {
                System.out.println(s);
            }
        }catch (Exception e){

        }
    }
}

