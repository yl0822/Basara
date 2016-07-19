package quartz;

import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by long.yl on 2016/7/18.
 */
public class TaskTest {

    @Test
    public void doExec() {
        try {
            String job_name = "动态任务调度";
            System.out.println("【系统启动】开始(每1秒输出一次)...");
            QuartzManager.addJob(job_name, DatePrintJob.class, "0/1 * * * * ?");

            Thread.sleep(5000);
            System.out.println("【修改时间】开始(每2秒输出一次)...");
            QuartzManager.modifyJobTime(job_name, "10/2 * * * * ?");
            Thread.sleep(6000);
            System.out.println("【移除定时】开始...");
            QuartzManager.removeJob(job_name);
            System.out.println("【移除定时】成功");

            System.out.println("【再次添加定时任务】开始(每10秒输出一次)...");
            QuartzManager.addJob(job_name, DatePrintJob.class, "*/10 * * * * ?");
            Thread.sleep(60000);
            System.out.println("【移除定时】开始...");
            QuartzManager.removeJob(job_name);
            System.out.println("【移除定时】成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Created by long.yl on 2016/7/18.
     */
    public static class DatePrintJob implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "★★★★★★★★★★");
        }
    }
}
