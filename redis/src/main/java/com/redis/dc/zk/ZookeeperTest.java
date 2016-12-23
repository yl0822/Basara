package com.redis.dc.zk;

import org.apache.log4j.Logger;
import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by long.yl
 * Created in 2016/12/23
 * Created on Basara_com.redis.dc.zk
 */
public class ZookeeperTest {

    private static final Logger logger = Logger.getLogger(ZookeeperTest.class);

    private static final int CLIENT_PORT = 2181;

    private static final int CONNECTION_TIMEOUT = 5000;

    private ZooKeeper zk;

    @Before
    public void init(){
        try {
            // 创建一个与服务器的连接
            zk = new ZooKeeper("localhost:" + CLIENT_PORT, CONNECTION_TIMEOUT, new Watcher() {
                // 监控所有被触发的事件
                public void process(WatchedEvent event) {
                    System.out.println("已经触发了" + event.getType() + "事件！");
                }
            });
        }catch (Exception e){
            logger.error("创建zk实例失败", e);
        }
    }

    @Test
    public void doTest() throws Exception{
        // 创建一个目录节点
        zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        // 创建一个子目录节点
        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath",false,null)));
        // 取出子目录节点列表
        System.out.println(zk.getChildren("/testRootPath",true));
        // 修改子目录节点数据
        zk.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1);
        System.out.println("目录节点状态：["+zk.exists("/testRootPath",true)+"]");
        // 创建另外一个子目录节点
        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null)));
        // 删除子目录节点
        zk.delete("/testRootPath/testChildPathTwo",-1);
        zk.delete("/testRootPath/testChildPathOne",-1);
        // 删除父目录节点
        zk.delete("/testRootPath",-1);
        // 关闭连接
        zk.close();
    }

    @Test
    public void zkLock() throws Exception {
        if (zk.exists("/LOCK", true) != null){
            System.out.println("删除LOCK节点...");
            zk.delete("/LOCK", -1);
        }
        zk.create("/LOCK", "rootlock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/LOCK/LOCK_1", "firstLock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        zk.create("/LOCK/LOCK_2", "secondLock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        zk.create("/LOCK/LOCK_3", "thirdLock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

        String needLockClient = "LOCK_0";
        zk.create("/LOCK/" + needLockClient, "lastLock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        String[] children = zk.getChildren("/LOCK", false).toArray(new String[]{});
        System.out.println(Arrays.toString(children));
        Arrays.sort(children);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start thread. ... ");
                try {
                    for (int i = 1; i <= 3; i++) {
                        Thread.currentThread().sleep(3000);
                        System.out.println("客户端："+Thread.currentThread().getName()+ ", 删除了" + "/LOCK/LOCK_" + i);
                        zk.delete("/LOCK/LOCK_" + i, -1);
                    }
                }catch (Exception e){

                }
            }
        }).start();
        if (children[0].equals(needLockClient)) {
            System.out.println("当前锁为最小锁");
            System.out.println("获取到锁");
            Thread.currentThread().sleep(5000);
            System.out.println("执行完成，释放锁...");
            zk.delete("/LOCK/" + needLockClient, -1);
        }else {
            while (zk.exists("/LOCK/" + children[0], true) != null){
                Thread.currentThread().sleep(100);
                System.out.println("---------------");
                children = zk.getChildren("/LOCK", false).toArray(new String[]{});
                Arrays.sort(children);
                if (children[0].equals(needLockClient)) {
                    System.out.println("当前锁非最小锁");
                    System.out.println("获取到锁");
                    Thread.currentThread().sleep(5000);
                    System.out.println("执行完成，释放锁...");
                    zk.delete("/LOCK/" + needLockClient, -1);
                }
            }
        }
    }
}
