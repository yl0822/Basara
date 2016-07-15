package taskqueue;

/**
 * @author long.yl.
 * @Date 2016/6/18
 */
public class TimeKillerTask implements Runnable {

    private String email;

    public TimeKillerTask(String email) {
        this.email = email;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 10000));
            System.out.println(Thread.currentThread().getName() + " -- " + email + " -- 邮件发送成功 .... ");
        } catch (Exception e) {

        }
    }
}
