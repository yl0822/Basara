package algorithm.netease.basara.lottery;

/**
 * @author long.yl.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;

/** 圣诞抽奖活动及地推活动工具类 */
public final class ChristmasConfig {

	/** 活动时间戳 */
	public static final long ACTIVITY_START_TIME = 1450713600;

	public static final long ACTIVITY_END_TIME = 1451059199;

	/** 微信接口相关 */
	public static final String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
	public static final String WX_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	public static final String WX_APP_ID = "wxcbf70cac329ba8a8";
	public static final String WX_APP_SECRET = "ca95925da93b2962d2b3a5025174911e";
	public static final String WX_GRANT_TYPE = "client_credential";
	public static final String WX_TYPE = "jsapi";

	/** H5抽奖活动限定奖品数量 */
	public static final int COUPON_99_90_ALL_COUNT = 100;
	public static final int COUPON_599_500_ALL_COUNT = 10;
	public static final int ELK_ALL_COUNT = 100;
	public static final int SUITCASE_ALL_COUNT = 10;

	/** 地推活动限定奖品数量 */
	public static final int LOCAL_COUPON_39_20_ALL_COUNT = 1000;

	public static final int LOCAL_COUPON_99_50_ALL_COUNT = 100;

	public static final int LOCAL_COUPON_199_100_ALL_COUNT = 20;

	public static final int LOCAL_COUPON_500_ALL_COUNT = 2;

	// 地推活动组编号
	public static final String LOCAL_ACTIVITY_GROUP = "4";

	/** 缓存列表 */
	public static List<Map<String, Long>> tokenList = new ArrayList<>();
	public static List<Map<String, Long>> ticketList = new ArrayList<>();
    public static Map<String, Long> ipMap = new HashMap<>();

	/** SHA1算法实现 */
	private static final int[] abcde = { 0x67452301, 0xefcdab89, 0x98badcfe, 0x10325476, 0xc3d2e1f0 };

	private static int[] digestInt = new int[5];

	private static int[] tmpData = new int[80];

	private static String byteToHexString(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}

	private static String byteArrayToHexString(byte[] bytearray) {
		String strDigest = "";
		for (int i = 0; i < bytearray.length; i++) {
			strDigest += byteToHexString(bytearray[i]);
		}
		return strDigest;
	}

	// 活动四天的限定奖品比例3:3:3:1
	public static int getMaxCountInDay(int allCount) {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DATE);
		if (day == 2 || day == 3 || day == 4) {
			return (allCount / 10) * 3;
		} else if (day == 5) {
			return allCount / 10;
		} else {
			return 0;
		}
	}

	public static String sha1(String string) {
		return getDigestOfString(string.getBytes());
	}

	private static int process_input_bytes(byte[] bytedata) {
		System.arraycopy(abcde, 0, digestInt, 0, abcde.length);
		byte[] newbyte = byteArrayFormatData(bytedata);
		int MCount = newbyte.length / 64;
		for (int pos = 0; pos < MCount; pos++) {
			for (int j = 0; j < 16; j++) {
				tmpData[j] = byteArrayToInt(newbyte, (pos * 64) + (j * 4));
			}
			encrypt();
		}
		return 20;
	}

	private static byte[] byteArrayFormatData(byte[] bytedata) {
		int zeros = 0;
		int size = 0;
		int n = bytedata.length;
		int m = n % 64;
		if (m < 56) {
			zeros = 55 - m;
			size = n - m + 64;
		} else if (m == 56) {
			zeros = 63;
			size = n + 8 + 64;
		} else {
			zeros = 63 - m + 56;
			size = (n + 64) - m + 64;
		}
		byte[] newbyte = new byte[size];
		System.arraycopy(bytedata, 0, newbyte, 0, n);
		int l = n;
		newbyte[l++] = (byte) 0x80;
		for (int i = 0; i < zeros; i++) {
			newbyte[l++] = (byte) 0x00;
		}
		long N = (long) n * 8;
		byte h8 = (byte) (N & 0xFF);
		byte h7 = (byte) ((N >> 8) & 0xFF);
		byte h6 = (byte) ((N >> 16) & 0xFF);
		byte h5 = (byte) ((N >> 24) & 0xFF);
		byte h4 = (byte) ((N >> 32) & 0xFF);
		byte h3 = (byte) ((N >> 40) & 0xFF);
		byte h2 = (byte) ((N >> 48) & 0xFF);
		byte h1 = (byte) (N >> 56);
		newbyte[l++] = h1;
		newbyte[l++] = h2;
		newbyte[l++] = h3;
		newbyte[l++] = h4;
		newbyte[l++] = h5;
		newbyte[l++] = h6;
		newbyte[l++] = h7;
		newbyte[l++] = h8;
		return newbyte;
	}

	private static int f1(int x, int y, int z) {
		return (x & y) | (~x & z);
	}

	private static int f2(int x, int y, int z) {
		return x ^ y ^ z;
	}

	private static int f3(int x, int y, int z) {
		return (x & y) | (x & z) | (y & z);
	}

	private static int f4(int x, int y) {
		return (x << y) | x >>> (32 - y);
	}

	private static void encrypt() {
		for (int i = 16; i <= 79; i++) {
			tmpData[i] = f4(tmpData[i - 3] ^ tmpData[i - 8] ^ tmpData[i - 14] ^ tmpData[i - 16], 1);
		}
		int[] tmpabcde = new int[5];
		for (int i1 = 0; i1 < tmpabcde.length; i1++) {
			tmpabcde[i1] = digestInt[i1];
		}
		for (int j = 0; j <= 19; j++) {
			int tmp = f4(tmpabcde[0], 5) + f1(tmpabcde[1], tmpabcde[2], tmpabcde[3]) + tmpabcde[4] + tmpData[j]
					+ 0x5a827999;
			tmpabcde[4] = tmpabcde[3];
			tmpabcde[3] = tmpabcde[2];
			tmpabcde[2] = f4(tmpabcde[1], 30);
			tmpabcde[1] = tmpabcde[0];
			tmpabcde[0] = tmp;
		}
		for (int k = 20; k <= 39; k++) {
			int tmp = f4(tmpabcde[0], 5) + f2(tmpabcde[1], tmpabcde[2], tmpabcde[3]) + tmpabcde[4] + tmpData[k]
					+ 0x6ed9eba1;
			tmpabcde[4] = tmpabcde[3];
			tmpabcde[3] = tmpabcde[2];
			tmpabcde[2] = f4(tmpabcde[1], 30);
			tmpabcde[1] = tmpabcde[0];
			tmpabcde[0] = tmp;
		}
		for (int l = 40; l <= 59; l++) {
			int tmp = f4(tmpabcde[0], 5) + f3(tmpabcde[1], tmpabcde[2], tmpabcde[3]) + tmpabcde[4] + tmpData[l]
					+ 0x8f1bbcdc;
			tmpabcde[4] = tmpabcde[3];
			tmpabcde[3] = tmpabcde[2];
			tmpabcde[2] = f4(tmpabcde[1], 30);
			tmpabcde[1] = tmpabcde[0];
			tmpabcde[0] = tmp;
		}
		for (int m = 60; m <= 79; m++) {
			int tmp = f4(tmpabcde[0], 5) + f2(tmpabcde[1], tmpabcde[2], tmpabcde[3]) + tmpabcde[4] + tmpData[m]
					+ 0xca62c1d6;
			tmpabcde[4] = tmpabcde[3];
			tmpabcde[3] = tmpabcde[2];
			tmpabcde[2] = f4(tmpabcde[1], 30);
			tmpabcde[1] = tmpabcde[0];
			tmpabcde[0] = tmp;
		}
		for (int i2 = 0; i2 < tmpabcde.length; i2++) {
			digestInt[i2] = digestInt[i2] + tmpabcde[i2];
		}
		for (int n = 0; n < tmpData.length; n++) {
			tmpData[n] = 0;
		}
	}

	private static int byteArrayToInt(byte[] bytedata, int i) {
		return ((bytedata[i] & 0xff) << 24) | ((bytedata[i + 1] & 0xff) << 16) | ((bytedata[i + 2] & 0xff) << 8)
				| (bytedata[i + 3] & 0xff);
	}

	private static void intToByteArray(int intValue, byte[] byteData, int i) {
		byteData[i] = (byte) (intValue >>> 24);
		byteData[i + 1] = (byte) (intValue >>> 16);
		byteData[i + 2] = (byte) (intValue >>> 8);
		byteData[i + 3] = (byte) intValue;
	}

	private static byte[] getDigestOfBytes(byte[] byteData) {
		process_input_bytes(byteData);
		byte[] digest = new byte[20];
		for (int i = 0; i < digestInt.length; i++) {
			intToByteArray(digestInt[i], digest, i * 4);
		}
		return digest;
	}

	private static String getDigestOfString(byte[] byteData) {
		return byteArrayToHexString(getDigestOfBytes(byteData));
	}

	private static int getIntIn1000() {
		int randomNum = (int) (Math.random() * 1001);
		return randomNum == 0 ? getIntIn1000() : randomNum;
	}

    /** 获取随机抽奖类型 */
	public static ChristmasSockType getSockType() {
		int num = getIntIn1000();
		if (num >= 1 && num <= 100) {
			return ChristmasSockType.COUPON_99_9;
		} else if (num >= 101 && num <= 250) {
			return ChristmasSockType.COUPON_199_16;
		} else if (num >= 251 && num <= 400) {
			return ChristmasSockType.COUPON_399_27;
		} else if (num >= 401 && num <= 490) {
			return ChristmasSockType.COUPON_499_36;
		} else if (num >= 491 && num <= 499) {
			return ChristmasSockType.COUPON_99_90;
		} else if (num == 500) {
			return ChristmasSockType.COUPON_599_500;
		} else if (num > 500 && num <= 700) {
			return ChristmasSockType.RED_1;
		} else if (num >= 701 && num <= 850) {
			return ChristmasSockType.RED_2;
		} else if (num >= 851 && num <= 950) {
			return ChristmasSockType.RED_3;
		} else if (num >= 951 && num <= 989) {
			return ChristmasSockType.RED_5;
		} else if (num >= 990 && num <= 999) {
			return ChristmasSockType.ELK;
		} else if (num == 1000) {
			return ChristmasSockType.SUITCASE;
		} else {
			return ChristmasSockType.NULL;
		}
	}

	/** 获取随机字符串 */
	public static String genRandomStr() {
		char[] letters = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C',
				'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
				'Y', 'Z' };
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			int seed = getIntIn58();
			builder.append(letters[seed]);
		}
		return builder.toString();
	}

	private static int getIntIn58() {
		int randomNum = (int) (Math.random() * 58);
		return randomNum;
	}


	/** 判断请求是否过快（防止机刷） */
    public static boolean isRequestTooFast(String ip) {
		if (ipMap.keySet().contains(ip) && (System.currentTimeMillis() - ipMap.get(ip)) < 1000) {
            addIp2Map(ip);
			return true;
        }
		addIp2Map(ip);
		return false;
    }
    private static void addIp2Map(String ip) {
        if (ipMap.size() >= 100) {
            ipMap.clear();
        } else {
            ipMap.put(ip, System.currentTimeMillis());
        }
	}

	/** 判断是否是圣诞页面发送的请求（防止模拟请求） */
	public static boolean isChristmasPageRequest(String signature) {
		return "99".equals(signature.substring(13, 15)) && "1".equals(signature.substring(3, 4));
	}

	/** 字符串拼接 */
	public static String packStr(String str1, String str2, String str3, String str4) {
		StringBuilder sb = new StringBuilder();
		sb.append("jsapi_ticket=").append(str1).append("&noncestr=").append(str2).append("&timestamp=").append(str3)
				.append("&url=").append(str4);
		return sb.toString();
	}

	/** 获取调用JSSDK的凭证 */
	@SuppressWarnings("unchecked")
	public static String getTicket() {
		try {
			// 如果缓存的ticket没有过期，直接返回
			if (ticketList.size() > 0) {
				Map<String, Long> map = ticketList.get(ticketList.size() - 1);
				for (String key : map.keySet()) {
					long createTime = map.get(key);
					if (System.currentTimeMillis() < (createTime + 7200000L)) {
						return key;
					}
				}
			}
			String ticket;
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(WX_TICKET_URL);
			String token = getToken();
			if (token == null) {
				return null;
			}
			HttpEntity httpEntity = MultipartEntityBuilder.create()
					.addPart("access_token", new StringBody(token, ContentType.TEXT_PLAIN))
					.addPart("type", new StringBody(WX_TYPE, ContentType.TEXT_PLAIN)).build();
			httpPost.setEntity(httpEntity);
			CloseableHttpResponse response = client.execute(httpPost);
			StringBuilder sb = new StringBuilder();
			BufferedReader reader;
			String tempLine;
			reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			while ((tempLine = reader.readLine()) != null) {
				sb.append(tempLine);
			}
			Map<String, String> result = new ObjectMapper().readValue(sb.toString(), Map.class);
			ticket = result.get("ticket");
			// 在服务器内存中缓存ticket
			Map<String, Long> ticketMap = new HashMap<>();
			ticketMap.put(ticket, System.currentTimeMillis());
			ticketList.add(ticketMap);
			return ticket;
		} catch (Exception e) {
			return null;
		}
	}

	// 根据access_token获取japi_ticket，access_token和ticket每天有调用上限，所以需要自行缓存到服务器，判断条件是Expire_In字段
	@SuppressWarnings("unchecked")
	private static String getToken() {
		try {
			// 如果缓存的token没有过期，直接返回
			if (tokenList.size() > 0) {
				Map<String, Long> map = tokenList.get(tokenList.size() - 1);
				for (String key : map.keySet()) {
					long createTime = map.get(key);
					if (System.currentTimeMillis() < (createTime + 7200000L)) {
						return key;
					}
				}
			}
			String accessToken;
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(WX_ACCESS_TOKEN_URL);
			HttpEntity httpEntity = MultipartEntityBuilder.create()
					.addPart("appid", new StringBody(WX_APP_ID, ContentType.TEXT_PLAIN))
					.addPart("secret", new StringBody(WX_APP_SECRET, ContentType.TEXT_PLAIN))
					.addPart("grant_type", new StringBody(WX_GRANT_TYPE, ContentType.TEXT_PLAIN)).build();
			httpPost.setEntity(httpEntity);
			CloseableHttpResponse response = client.execute(httpPost);
			StringBuilder sb = new StringBuilder();
			BufferedReader reader;
			String tempLine;
			reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			while ((tempLine = reader.readLine()) != null) {
				sb.append(tempLine);
			}
			Map<String, String> result = new ObjectMapper().readValue(sb.toString(), Map.class);
			accessToken = result.get("access_token");
			// 在服务器内存中缓存token
			Map<String, Long> tokenMap = new HashMap<>();
			tokenMap.put(accessToken, System.currentTimeMillis());
			tokenList.add(tokenMap);
			return accessToken;
		} catch (Exception e) {
			return null;
		}
	}

	/** 获取活动开始时间戳 */
	public static long getDayStartTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		StringBuilder date = new StringBuilder("2015-12-");
		date.append(calendar.get(Calendar.DATE));
		date.append(" 00:00:00");
		try {
			return sdf.parse(date.toString()).getTime();
		} catch (Exception e) {
			return 0;
		}
	}

	/** 获取活动截止时间戳 */
	public static long getDayEndTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		StringBuilder date = new StringBuilder("2015-12-");
		date.append(calendar.get(Calendar.DATE));
		date.append(" 23:59:59");
		try {
			return sdf.parse(date.toString()).getTime();
		} catch (Exception e) {
			return 0;
		}
	}

	/** 地推活动抽奖规则 */
	public static ChristmasSockType getLocalType() {
		int num = getIntIn1000();
		if (num >= 1 && num <= 328) {
			return ChristmasSockType.LOCAL_COUPON_19_10;
		} else if (num >= 329 && num <= 656) {
			return ChristmasSockType.LOCAL_COUPON_29_15;
		} else if (num >= 657 && num <= 984) {
			return ChristmasSockType.LOCAL_COUPON_39_20;
		} else if (num >= 985 && num < 994) {
			return ChristmasSockType.LOCAL_COUPON_99_50;
		} else if (num >= 995 && num <= 999) {
			return ChristmasSockType.LOCAL_COUPON_199_100;
		} else if (num == 1000) {
			return ChristmasSockType.LOCAL_COUPON_500;
		} else {
			return ChristmasSockType.NULL;
		}
	}
}
