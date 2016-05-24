package videocenter.dao.util;

import java.util.Date;
import java.util.UUID;

import org.apache.http.client.methods.HttpPost;

/**
 * @author long.yl.
 * @Date 2016/5/9
 */
public class HeaderHelper {
	public static void addHeader(HttpPost httpPost) {
		String nonce = UUID.randomUUID().toString();
		String curTime = String.valueOf((new Date()).getTime() / 1000L);
		// 参考 计算CheckSum的java代码
		String checkSum = CheckSumBuilder.getCheckSum(Constants.APPSECRET, nonce, curTime);

		// 设置请求的header
		httpPost.addHeader("AppKey", Constants.APPKEY);
		httpPost.addHeader("Nonce", nonce);
		httpPost.addHeader("CurTime", curTime);
		httpPost.addHeader("CheckSum", checkSum);
		httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
	}
}
