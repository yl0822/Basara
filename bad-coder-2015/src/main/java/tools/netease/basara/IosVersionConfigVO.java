package tools.netease.basara;

import java.io.Serializable;

/**
 * @author long.yl.
 */
public class IosVersionConfigVO implements Serializable{

    private static final long serialVersionUID = -1230062414860419999L;

    /** ios版本号 */
    private String version;

    /** 版本对应的配置 */
    private Config config;

    public IosVersionConfigVO() {
    }

    public IosVersionConfigVO(String version, int patchVersion, int configType, int loadType, String patchURL, String patchMD5) {
        this.version = version;
        Config config = new Config();
        config.setConfigType(configType);
        config.setLoadType(loadType);
        config.setPatchMD5(patchMD5);
        config.setPatchURL(patchURL);
        config.setPatchVersion(patchVersion);
        this.config = config;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    static class Config{

        //补丁版本号，每个应用版本独立，从1开始递增
        private int patchVersion;

        //配置类型：0升级补丁，1删除补丁
        private int configType;

        //加载类型：0下次启动加载，1立即加载
        private int loadType;

        //补丁下载URL，可以是普通http链接
        private String patchURL;

        //补丁MD5值，防篡改校验
        private String patchMD5;

        public int getPatchVersion() {
            return patchVersion;
        }

        public void setPatchVersion(int patchVersion) {
            this.patchVersion = patchVersion;
        }

        public int getConfigType() {
            return configType;
        }

        public void setConfigType(int configType) {
            this.configType = configType;
        }

        public int getLoadType() {
            return loadType;
        }

        public void setLoadType(int loadType) {
            this.loadType = loadType;
        }

        public String getPatchURL() {
            return patchURL;
        }

        public void setPatchURL(String patchURL) {
            this.patchURL = patchURL;
        }

        public String getPatchMD5() {
            return patchMD5;
        }

        public void setPatchMD5(String patchMD5) {
            this.patchMD5 = patchMD5;
        }

        @Override
        public String toString() {
            return "Config{" +
                    "patchVersion=" + patchVersion +
                    ", configType=" + configType +
                    ", loadType=" + loadType +
                    ", patchURL='" + patchURL + '\'' +
                    ", patchMD5='" + patchMD5 + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "IosVersionConfigVO{" +
                "version='" + version + '\'' +
                ", config=" + config +
                '}';
    }
}
