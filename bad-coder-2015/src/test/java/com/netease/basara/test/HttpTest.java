package com.netease.basara.test;

import algorithm.netease.basara.AesBasara;
import algorithm.netease.basara.HexStringBasara;
import algorithm.netease.basara.Md5Basara;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import tools.netease.basara.LoggerBasara;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author long.yl.
 * @Date 2016/1/14
 */
public class HttpTest {

    HttpBasara httpBasara;

    String username;

    String password;

    String uniqueID;

    @Before
    public void init() {
        httpBasara = new HttpBasara();
        username = "laotest12@163.com";
        password = "qa1234";
        uniqueID = "412YL4CAA1289E0089CC67D4E87F9831";
    }

    @Test
    public void mainTest() {
        HttpBasara basara = new HttpBasara();
        Map<String, String> requestHeadParams = new HashMap<>();
        requestHeadParams
                .put("token",
                        "389CB8CFC156ECD9384E600897EB2F6319E55051F7A5B1F0C7C51E1357E897C8AC4117F927BD2E934B5D01E1F0403C15B4C1FED00B2111DE700F552F39962707|16DD788F9898C9010D339F53DD73B253D27642CE6CF1CA7A11831B017A543036E4EDD3253746BCE7E7983D77D5F6412B");
        basara.doPostRequest("http://m.paopao.163.com/m/v2/editAccount", requestHeadParams, null);
        basara.doGetRequest("http://m.paopao.163.com/m/v2/getRecmSearchKey", null);
    }

    @Test
    public void appAuth() throws UnsupportedEncodingException {
        String url = "http://m2.paopao.163.com/m/initApp?product=ht_client&pdtVersion=1&mac=11%253A22%253A33%253A44%253A55%253A66&deviceType=iphone&systemName=ios&systemVersion=7.0&resolution=640%252A1136&uniqueID=412YL4CAA1289E0089CC67D4E87F9831";
        String jsonString = httpBasara.doGetRequest(url, null);
        if (jsonString != null) {
            JSONObject object = JSONObject.parseObject(jsonString);
            String id = object.getJSONObject("result").getString("id");
            String key = object.getJSONObject("result").getString("key");
            String pw = Md5Basara.string2MD5(password);
            byte[] temp = HexStringBasara.hexStr2Bytes(key);
            String s = "username=" + username + "&password=" + pw + "&uniqueID=" + uniqueID;
            byte[] encryptResult = AesBasara.encrypt(s, new String(temp, "UTF-8"));
            String encryptResultStr = HexStringBasara.byte2HexStr(encryptResult);
            Map<String, String> requestParams = new HashMap<>();
            requestParams.put("id", id);
            requestParams.put("params", encryptResultStr);
            String jsonString2 = httpBasara.doGetRequest("http://m2.paopao.163.com/m/v2/login", requestParams);
            if (jsonString2 == null) {
                JSONObject object2 = JSONObject.parseObject(jsonString2);
                String result2 = object2.getJSONObject("result").getString("result");
                byte[] temp2 = HexStringBasara.hexStr2Bytes(key);
                byte[] decryptResultStr = HexStringBasara.hexStr2Bytes(result2);
                String decryptResult = AesBasara.decrypt(decryptResultStr, new String(temp2, "UTF-8"));
                String apptoken = decryptResult.split("&")[0];
                String token = apptoken + "|" + id;
                System.out.println(token);
            }
        } else {
            LoggerBasara.info(this.getClass(), "response entity is empty!");
        }
    }
}
