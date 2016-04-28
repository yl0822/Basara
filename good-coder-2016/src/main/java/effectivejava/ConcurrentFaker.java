package effectivejava;/**
 * @author long.yl.
 * @Date 2016/3/31
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class ConcurrentFaker extends Application {

    static boolean isStop = false;

    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isStop){
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(i++);
                }
            }
        });
        myThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        isStop = true;
    }

    @Override
    public void start(Stage primaryStage) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isStop){
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(i++);
                }
            }
        });
        myThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        isStop = true;
    }
}
