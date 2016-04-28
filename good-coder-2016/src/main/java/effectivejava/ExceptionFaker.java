package effectivejava;/**
 * @author long.yl.
 * @Date 2016/3/31
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExceptionFaker extends Application {
    static class FakerException extends Exception{

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
//        FileInputStream fileInputStream = new FileInputStream(new File(""));
//        Object object = new Object();
//        object.toString("asdasd");
        Map<String, Object> map = new HashMap<>(10);
        map.put("a", "aaa");
        map.put("b", "aaa");
        map.put("c", "aaa");
        map.put("d", "aaa");
        for (String s : map.keySet()) {
            /**
             * 下面的第一句会报ConcurrentModificationException异常，而第二句不会
             * 原因在于第一句修改了映射关系集合的结构（增删）
             *
             * */
            map.remove("k");
//                map.put("b", "ccc");

        }
    }
}
