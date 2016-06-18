package taskqueue;

/**
 * @author long.yl.
 * @Date 2016/6/18
 */
public class App {
    public static void main(String[] args) {
        final TaskProducer<TimeKillerTask> producer = new EmailTaskProducer();
        final TaskConsumer consumer = new TaskConsumer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程: " + Thread.currentThread().getName() + " 启动消费者 ... ");
                consumer.killTask(producer);
            }
        }).start();


        while (true) {
            try {
                int seed = (int)(Math.random() * 1000);
                Thread.sleep(seed);
                System.out.println("主线程向队列添加任务，目前任务队列长度：" + producer.howMany());
                producer.addTask(new TimeKillerTask("sd_style@163.com:" + seed));
            }catch (Exception e){

            }
        }

//        for (int i = 100; i < 110; i++) {
//            producer.addTask(new TimeKillerTask("sd_style@163.com:" + i));
//        }

//        System.out.println("主线程结束 .");
//        consumer.close();
    }
}
