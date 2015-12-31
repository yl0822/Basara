package others;

import java.io.Serializable;

/**
 * @author long.yl.
 */
public class IosVersionConfigVO implements Serializable{

    private static final long serialVersionUID = -1230062414860419999L;

    /** ios�汾�� */
    private String version;

    /** �汾��Ӧ������ */
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

        //�����汾�ţ�ÿ��Ӧ�ð汾��������1��ʼ����
        private int patchVersion;

        //�������ͣ�0����������1ɾ������
        private int configType;

        //�������ͣ�0�´��������أ�1��������
        private int loadType;

        //��������URL����������ͨhttp����
        private String patchURL;

        //����MD5ֵ�����۸�У��
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
