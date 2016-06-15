package concurrent.volatile_atomic;

/**
 * @author long.yl.
 * @Date 2016/6/14
 */
public class ConutSheep {
    private static boolean asleep;
    private static int number;

    private static void countSheep(){
        System.out.println(number++);
    }

    private static class CountThread extends Thread{
        @Override
        public void run() {
            while (!asleep){
                try {
                    Thread.sleep(100);
                }catch (Exception e){

                }
                countSheep();
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) throws Exception{
        asleep = false;
        number = 0;
        new CountThread().start();
        Thread.sleep(1000);
        asleep = true;
    }
}
