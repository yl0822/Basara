package stopwatch;

import org.apache.commons.lang3.time.StopWatch;

/**
 * Created by long.yl
 * Created in 2016/8/30
 * Created on Basara_stopwatch
 */
public class StopWatcher {
    public static void main(String[] args) throws Throwable{
        StopWatch watch = new StopWatch();
        watch.start();
        Thread.sleep(1000);
        watch.split();
        /*
         * This is the time between start and latest split.
         * 调用start()方法到最后一次调用split()方法耗用的时间
         */
        System.out.println(watch.getSplitTime());
        Thread.sleep(2000);
        watch.split();
        System.out.println(watch.getSplitTime());
        Thread.sleep(500);
        watch.stop();
        /*
         * This is either the time between the start and the moment this method
         * is called, or the amount of time between start and stop
         * 调用start()方法到调用getTime()或stop()方法耗用的时间
         */
        System.out.println(watch.getTime());
    }
}
