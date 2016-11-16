package juc.executor;

import concurrent.countdownlatch.Task;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by long.yl
 * Created in 2016/11/2
 * Created on Basara_juc.executor
 */
public class ScheduleExeTask {

    private static Executor executor;

    private static class PrintTask implements Task{
        @Override
        public void execute() {
            long start = System.currentTimeMillis();
            String str = "[ar:谢安琪] \n" +
                    "[ti:钟无艳] \n" +
                    "[t_time:(4:36)] \n" +
                    "[00:09.91] 钟无艳 - 谢安琪\n" +
                    "[00:21.54] 其实我怕你总夸奖高估我坚忍\n" +
                    "[00:24.83] 其实更怕你只懂得欣赏我品行\n" +
                    "[00:29.52] 无人及我用字绝重拾了你信心\n" +
                    "[00:32.30] 无人问我可甘心演这伟大 化身\n" +
                    "[00:38.48] 其实我想间中崩溃脆弱如恋人\n" +
                    "[00:42.36] 谁在你两臂中低得不需要身份\n" +
                    "[00:46.58] 无奈被你识穿这个念头 得到好处的你\n" +
                    "[00:50.75] 明示不想失去绝世好友\n" +
                    "[00:55.39] 没有得你的允许 我都会爱下去\n" +
                    "[00:59.45] 互相祝福心软之际或者准我吻下去\n" +
                    "[01:03.58] 我痛恨成熟到 不要你望着我流泪\n" +
                    "[01:08.44] 但漂亮笑下去 彷佛冬天饮雪水\n" +
                    "[01:12.42] 被你一贯的赞许 却不配爱下去\n" +
                    "[01:16.12] 在你悲伤一刻必须解慰找到我乐趣\n" +
                    "[01:21.86] 我甘于当副车 也是快乐着唏嘘\n" +
                    "[01:25.18] 彼此这么了解\n" +
                    "[01:27.37] 难怪注定似兄妹一对\n" +
                    "[02:04.16] 其实我怕你的好感基于我修养\n" +
                    "[02:07.28] 其实最怕你的私心亏准我体谅\n" +
                    "[02:12.11] 无人问我寂寞像投何处去养伤\n" +
                    "[02:15.73] 原来是我的心境高到变为 偶像\n" +
                    "[02:21.09] 谁情愿照耀着别人就如 月亮\n" +
                    "[02:23.99] 为奴婢为你备饭奉茶是残忍真相\n" +
                    "[02:27.90] 无奈被你识穿这个念头 得到好处的你\n" +
                    "[02:33.45] 明示不想失去绝世好友\n" +
                    "[02:38.17] 没有得你的允许 我都会爱下去\n" +
                    "[02:42.23] 互相祝福心软之际或者准我吻下去\n" +
                    "[02:46.77] 我痛恨成熟到 不要你望着我流泪\n" +
                    "[02:51.31] 但漂亮笑下去 彷佛冬天饮雪水\n" +
                    "[02:54.81] 被你一贯的赞许 却不配爱下去\n" +
                    "[02:59.96] 在你悲伤一刻必须解慰找到我乐趣\n" +
                    "[03:04.56] 我甘于当副车 也是快乐着唏嘘\n" +
                    "[03:08.10] 彼此这么了解\n" +
                    "[03:10.19] 让我决定我的快乐\n" +
                    "[03:12.89] 那须得你的允许 我都会爱下去\n" +
                    "[03:17.15] 互相祝福心软之际或者准我吻下去\n" +
                    "[03:20.76] 我痛恨成熟到 不要你望着我流泪\n" +
                    "[03:24.92] 但漂亮笑下去 彷佛冬天饮雪水\n" +
                    "[03:28.70] 被你一贯的赞许 无须装说下去\n" +
                    "[03:33.71] 在你悲伤一刻必须解慰找到我乐趣\n" +
                    "[03:38.50] 我甘于当副车 却没法撞入堡垒\n" +
                    "[03:43.25] 彼此这么了解 难怪注定似兄妹一对\n" +
                    "[03:52.06] 你的他怎允许 结伴观赏雪的泪\n" +
                    "[03:56.64] 永不开封的汽水 让我抱在怀内吻下去";
            String str2 = "[ar:谢安琪] \n" +
                    "[ti:钟无艳] \n" +
                    "[t_time:(4:36)] \n" +
                    "[00:09.91] 钟无艳 - 谢安琪\n" +
                    "[00:21.54] 其实我怕你总夸奖高估我坚忍\n" +
                    "[00:24.83] 其实更怕你只懂得欣赏我品行\n" +
                    "[00:29.52] 无人及我用字绝重拾了你信心\n" +
                    "[00:32.30] 无人问我可甘心演这伟大 化身\n" +
                    "[00:38.48] 其实我想间中崩溃脆弱如恋人\n" +
                    "[00:42.36] 谁在你两臂中低得不需要身份\n" +
                    "[00:46.58] 无奈被你识穿这个念头 得到好处的你\n" +
                    "[00:50.75] 明示不想失去绝世好友\n" +
                    "[00:55.39] 没有得你的允许 我都会爱下去\n" +
                    "[00:59.45] 互相祝福心软之际或者准我吻下去\n" +
                    "[01:03.58] 我痛恨成熟到 不要你望着我流泪\n" +
                    "[01:08.44] 但漂亮笑下去 彷佛冬天饮雪水\n" +
                    "[01:12.42] 被你一贯的赞许 却不配爱下去\n" +
                    "[01:16.12] 在你悲伤一刻必须解慰找到我乐趣\n" +
                    "[01:21.86] 我甘于当副车 也是快乐着唏嘘\n" +
                    "[01:25.18] 彼此这么了解\n" +
                    "[01:27.37] 难怪注定似兄妹一对\n" +
                    "[02:04.16] 其实我怕你的好感基于我修养\n" +
                    "[02:07.28] 其实最怕你的私心亏准我体谅\n" +
                    "[02:12.11] 无人问我寂寞像投何处去养伤\n" +
                    "[02:15.73] 原来是我的心境高到变为 偶像\n" +
                    "[02:21.09] 谁情愿照耀着别人就如 月亮\n" +
                    "[02:23.99] 为奴婢为你备饭奉茶是残忍真相\n" +
                    "[02:27.90] 无奈被你识穿这个念头 得到好处的你\n" +
                    "[02:33.45] 明示不想失去绝世好友\n" +
                    "[02:38.17] 没有得你的允许 我都会爱下去\n" +
                    "[02:42.23] 互相祝福心软之际或者准我吻下去\n" +
                    "[02:46.77] 我痛恨成熟到 不要你望着我流泪\n" +
                    "[02:51.31] 但漂亮笑下去 彷佛冬天饮雪水\n" +
                    "[02:54.81] 被你一贯的赞许 却不配爱下去\n" +
                    "[02:59.96] 在你悲伤一刻必须解慰找到我乐趣\n" +
                    "[03:04.56] 我甘于当副车 也是快乐着唏嘘\n" +
                    "[03:08.10] 彼此这么了解\n" +
                    "[03:10.19] 让我决定我的快乐\n" +
                    "[03:12.89] 那须得你的允许 我都会爱下去\n" +
                    "[03:17.15] 互相祝福心软之际或者准我吻下去\n" +
                    "[03:20.76] 我痛恨成熟到 不要你望着我流泪\n" +
                    "[03:24.92] 但漂亮笑下去 彷佛冬天饮雪水\n" +
                    "[03:28.70] 被你一贯的赞许 无须装说下去\n" +
                    "[03:33.71] 在你悲伤一刻必须解慰找到我乐趣\n" +
                    "[03:38.50] 我甘于当副车 却没法撞入堡垒\n" +
                    "[03:43.25] 彼此这么了解 难怪注定似兄妹一对\n" +
                    "[03:52.06] 你的他怎允许 结伴观赏雪的泪\n" +
                    "[03:56.64] 永不开封的汽水 让我抱在怀内吻下去";
            System.out.println(str.equals(str2));
            System.out.println(System.currentTimeMillis() - start);
        }
    }

    static {
        executor = Executors.newScheduledThreadPool(5);
    }

    /**
     * 延迟处理
     * @param task 干什么
     * @param second 多久之后干
     * */
    public static void delay2Do(final Task task, long second){
        ((ScheduledExecutorService)executor).scheduleAtFixedRate(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                task.execute();
                count++;
                if (count == 5){
                    ((ScheduledExecutorService) executor).shutdown();
                }
            }
        }, second, 1L,TimeUnit.SECONDS);
        System.out.println("end?");
    }

    public static void main(String[] args) {
        ScheduleExeTask.delay2Do(new PrintTask(), 5);
        System.out.println("main?");
    }
}