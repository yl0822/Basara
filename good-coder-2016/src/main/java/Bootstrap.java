import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * Created by Larry .Yang
 * on 16/3/25 13:49
 * Package: parent_PACKAGE_NAME
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        scanAPI();
    }

    public static void scanAPI() {
        File controller = new File("F:\\git\\mainserver\\src\\main\\java\\com\\netease\\music\\controller");
        try {
            scanDir(controller);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void scanDir(File file)throws Exception {
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                if (file1.isDirectory()){
                    scanDir(file1);
                }else {
                    System.out.println(file1.getName());
                    System.out.println(file1.getPath());
                    if (file1.getName().endsWith("Controller")) {
                        Class clazz = Class.forName(file1.getPath());
                        clazz.
                    }
                }
            }
        }
    }


    public static void removeSubList(){
        File file = new File("C:\\Users\\long.yl\\Desktop\\aaa.txt");
        File file2 = new File("C:\\Users\\long.yl\\Desktop\\bbb.txt");
        LineIterator it = null;
        try {
            it = FileUtils.lineIterator(file, "UTF-8");
            List<String> list = new ArrayList<>();
            while (it.hasNext()) {
                String line = it.nextLine();
                list.add(line);
            }
            it = FileUtils.lineIterator(file2, "UTF-8");
            List<String> list2 = new ArrayList<>();
            while (it.hasNext()) {
                String line = it.nextLine();
                list2.add(line);
            }
            List<String> newlist = new ArrayList<>();
            outterLoop: for (String line : list) {
                for (String line2 : list2) {
                    if (line.equals(line2)) {
                        continue outterLoop;
                    }
                }
                newlist.add(line);
            }
            for (String s : newlist) {
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void jar(){
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
                    filename = filename.substring(0, filename.lastIndexOf("-"));
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

