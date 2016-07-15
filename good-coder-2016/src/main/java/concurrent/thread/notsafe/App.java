package concurrent.thread.notsafe;

/**
 * @author long.yl.
 * @Date 2016/6/3
 */
public class App {

    public static void main(String[] args) {
        final Calculator calculator = new Calculator();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (calculator.i < 1000) {
                    calculator.incrAndPrint();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (calculator.i < 1000) {
                    calculator.incrAndPrint();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (calculator.i < 1000) {
                    calculator.incrAndPrint();
                }
            }
        }).start();
    }

    static class Calculator {
        int i = 0;

        public void incrAndPrint() {
            i = i + 1;
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (Exception e) {

            }
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
