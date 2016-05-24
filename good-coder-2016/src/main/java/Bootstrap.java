import java.io.File;
import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Larry .Yang
 * on 16/3/25 13:49
 * Package: parent_PACKAGE_NAME
 */
public class Bootstrap {

    public static void main(String[] args) throws Exception{
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        System.out.println("新建list "+Arrays.toString(list.toArray()));
        List<String> newList = new ArrayList<>(list);
        newList.remove(newList.size() - 1);
        System.out.println("被移除后的原list "+Arrays.toString(list.toArray()));
        System.out.println("newList "+Arrays.toString(newList.toArray()));
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
