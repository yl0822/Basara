package distributelock.zk;

/**
 * Created by long.yl
 * Created in 2016/8/19
 * Created on Basara_distributelock.zk
 */
public class ZKLock {

    private ZKClient zkClient;


    public static final String LOCK_ROOT = "/lock";
    private String lockName;


    public ZKLock(String connectString, int sessionTimeout, String lockName) throws Exception {
        //先创建zk链接.
        this.createConnection(connectString,sessionTimeout);

        this.lockName = lockName;
    }

    public boolean tryLock(){
        String path = ZKUtil.contact(LOCK_ROOT,lockName);
        String localIp = NetworkUtil.getNetworkAddress();
        try {
            if(zkClient.exists(path)){
                String ownnerIp = zkClient.getData(path);
                if(localIp.equals(ownnerIp)){
                    return true;
                }
            } else {
                zkClient.createPathIfAbsent(path,false);
                if(zkClient.exists(path)){
                    String ownnerIp = zkClient.getData(path);
                    if(localIp.equals(ownnerIp)){
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 创建zk连接
     *
     */
    protected void createConnection(String connectString, int sessionTimeout) throws Exception {
        if(zkClient != null){
            releaseConnection();
        }
        zkClient = new ZKClient(connectString,sessionTimeout);
        zkClient.createPathIfAbsent(LOCK_ROOT,true);
    }
    /**
     * 关闭ZK连接
     */
    protected void releaseConnection() throws InterruptedException {
        if (zkClient != null) {
            zkClient.close();
        }
    }

}
