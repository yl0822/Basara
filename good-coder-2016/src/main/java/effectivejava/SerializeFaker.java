package effectivejava;/**
 * @author long.yl.
 * @Date 2016/3/30
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;

public class SerializeFaker extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        /**------------------------------序列化--------------------------------------------*/
        Computer computer = new Computer();
        computer.setCpu("inter i7");
        computer.setBrand("lenovo");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\computor.txt"))) {
            oos.writeObject(computer);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**-------------------------------反序列化-------------------------------------------*/
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\computor.txt"))) {
            Computer computer1 = (Computer) ois.readObject();
            System.out.println(computer1.getCpu());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Computer implements Serializable {
        private String cpu;
        private String brand;

        public String getCpu() {
            return cpu;
        }

        public void setCpu(String cpu) {
            this.cpu = cpu;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }
    }
}
