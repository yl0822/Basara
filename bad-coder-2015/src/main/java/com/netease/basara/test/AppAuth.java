//package com.netease.basara.test;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
//import net.sf.json.JSONObject;
//
//import org.apache.http.NameValuePair;
//import org.apache.http.client.utils.URLEncodedUtils;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.protocol.HTTP;
//import org.testng.Assert;
//
//import com.netease.qa.meta.HttpType;
//import com.netease.qa.meta.Response;
//import com.netease.qa.request.AppRequest;
//import com.netease.qa.utils.AES;
//import com.netease.qa.utils.MD5;
//import com.netease.qa.utils.Utils;
//
//
//
//
//public class AppAuth {
//
//	public static String getToken(CloseableHttpClient client, String username, String password)
//	{
//		String mobToken = null;
//		String ursToken = AppAuth.getURSToken(client, username, password);
//		mobToken = AppAuth.authEdu(client, username, ursToken);
//		return mobToken;
//	}
//
//	public static String authVStore(CloseableHttpClient client, String username, String password) {
//
//		String url = "http://m.paopao.163.com/m/initApp?product=ht_client&pdtVersion=1&mac=11%253A22%253A33%253A44%253A55%253A66&deviceType=iphone&systemName=ios&systemVersion=7.0&resolution=640%252A1136&uniqueID=412DB4CAA1289E0089CC67D4E87F9831";
//		AppRequest request = new AppRequest();
//		Response response = request.http(client, HttpType.GET, url, null, null, HTTP.UTF_8);
//
//		JSONObject json = JSONObject.fromObject(response.getBody());
//
//		String id = json.getJSONObject("result").getString("id");
//		String key = json.getJSONObject("result").getString("key");
//
//		String pw = Utils.MD5Encrypt(password);
//		String uniqueID = "412DB4CAA1289E0089CC67D4E87F9831";
//		byte[] temp = Utils.parseHexStr2Byte(key);
//
//		String s = "username=" + username + "&password=" + pw + "&uniqueID="
//				+ uniqueID;
//		byte[] encryptResult = Utils.encryptAES(s, temp);
//		String encryptResultStr = Utils.parseByte2HexStr(encryptResult);
//
//		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
//		nvp.add(new BasicNameValuePair("id", id));
//		nvp.add(new BasicNameValuePair("params", encryptResultStr));
//
//		response = request.http(client, HttpType.GET, "http://m.paopao.163.com/m/v2/login?"+URLEncodedUtils.format(nvp, "UTF-8"), null, null, HTTP.UTF_8);
//		JSONObject login_result = JSONObject.fromObject(response.getBody());
//
//		String result = login_result.getJSONObject("result").getString("result");
//		byte[] temp2 = Utils.parseHexStr2Byte(key);
//		byte[] decryptResultStr = Utils.parseHexStr2Byte(result);
//		String decryptResult = Utils.decryptAES(decryptResultStr, temp2);
//		String apptoken = decryptResult.split("&")[0];
//		String token = apptoken + "|" + id;
//		return token;
//
//	}
//
//
//	private static String authEdu(CloseableHttpClient client, String username,String ursToken)
//	{
//		String email = username.split("@163")[0];
//
//		String url = "http://study.163.com/mob/logonForAndroid";
//		Properties prop = new Properties();
//		InputStream in = Object.class.getResourceAsStream( "/urs.properties" );
//		String key = null;
//		String id = null;
//
//		try {
//			prop.load(in);
//			key = prop.getProperty("key");
//			id = prop.getProperty("id");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		String time = Long.toString(System.currentTimeMillis());
//		JSONObject xParam = new JSONObject();
//		xParam.accumulate("timestamp", time);
//		xParam.accumulate("token", ursToken);
//		xParam.accumulate("tokenId", id);
//		xParam.accumulate("email", email);
//		String xParamString = xParam.toString();
//
//		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
//		nvp.add(new BasicNameValuePair("mob-token",""));
//		nvp.add(new BasicNameValuePair("email",email));
//		nvp.add(new BasicNameValuePair("app_auth","1"));
//		//nvp.add(new BasicNameValuePair("channelId","ykt_store_360"));
//		nvp.add(new BasicNameValuePair("logon_type","-1"));
//		nvp.add(new BasicNameValuePair("x_param",xParamString));
//
//		AppRequest request = new AppRequest();
//
//		Response response = request.http(client, HttpType.POST, url, nvp, null, HTTP.UTF_8);
//		JSONObject json = JSONObject.fromObject(response.getBody());
//		String token = null;
//		if(json.getJSONObject("status").getInt("code") == 0)
//		{
//			token = json.getJSONObject("results").getString("mob-token");
//		}
//		else
//		{
//			Assert.assertEquals(0, json.getJSONObject("status").getInt("code"),"登录失败~");
//		}
//
//		return token;
//	}
//
//
//	private static String getURSToken(CloseableHttpClient client, String username, String password) {
//		String url = "http://reg.163.com/services/safeUserLoginForMob";
//		Properties prop = new Properties();
//		InputStream in = Object.class.getResourceAsStream( "/urs.properties" );
//		String key = null;
//		String id = null;
//
//		try {
//			prop.load(in);
//			key = prop.getProperty("key");
//			id = prop.getProperty("id");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		String md5Password = MD5.md5(password);
//		String src = "username=" + username + "&password=" + md5Password;
//		String paras = null;
//		try {
//			paras = AES.byte2hex(AES.encrypt(src.toString()
//					.getBytes("utf-8"), AES.hex2byte(key)));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
//		nvp.add(new BasicNameValuePair("id", id));
//		nvp.add(new BasicNameValuePair("params", paras));
//
//		AppRequest request = new AppRequest();
//		Response response = request.http(client, HttpType.POST, url, nvp, null, HTTP.UTF_8);
//
//		String authResult = response.getBody();
//
//		System.out.println("URS response: " + authResult);
//
//		String result = parseResult(authResult);
//		System.out.println("result: " + result);
//
//		String returnPara = null;
//		try {
//			returnPara = new String(AES.decrypt(AES.hex2byte(result),
//					AES.hex2byte(key)));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String token = parseToken(returnPara);
//		System.out.println("token: " + token);
//
//		return token;
//	}
//
//	private static String parseResult(String res) {
//		if (!res.contains("201")) {
//			return "URS not 201";
//		} else {
//			int start = res.indexOf("result=");
//			String result = res.substring(start + 7, res.length() - 1);
//			return result;
//		}
//	}
//
//	private static String parseToken(String res) {
//		int start = res.indexOf("token=");
//		String result = res.substring(start + 6, res.length());
//
//		return result;
//	}
//
//
//
//}
