package effectivejava;

/**
 * @author long.yl.
 * @Date 2016/4/2
 */
public class SychronizedFaker {

    private String name = "yl";

    static boolean flag = false;

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        final SychronizedFaker faker = new SychronizedFaker();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    faker.setName();
                }
                flag = true;
            }
        });
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag){
                    System.out.println("---"+ faker.getName());
                }
            }
        });
        thread1.start();
    }

    public void setName(){
        String[] strings = {"aaa", "bbb", "ccc", "ddd", "eee"};
        int rondom = (int)(Math.random() * 5);
        this.name = strings[rondom];
        System.out.println(name);
    }
}
