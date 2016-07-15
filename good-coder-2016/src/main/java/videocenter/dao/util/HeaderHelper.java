package videocenter.dao.util;

import org.apache.http.client.methods.HttpPost;

import java.util.Date;
import java.util.UUID;

/**
 * @author long.yl.
 * @Date 2016/5/9
 */
public class HeaderHelper {
    public static void addHeader(HttpPost httpPost) {
        String nonce = UUID.randomUUID().toString();
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        // �ο� ����CheckSum��java����
        String checkSum = CheckSumBuilder.getCheckSum(Constants.APPSECRET, nonce, curTime);

        // ���������header
        httpPost.addHeader("AppKey", Constants.APPKEY);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
    }
}
