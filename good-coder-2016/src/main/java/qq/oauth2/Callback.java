package qq.oauth2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by long.yl
 * Created in 2016/8/4
 * Created on Basara_qq.oauth2
 */
public class Callback{
    public static String doConnect(String code, File jsonFile){
        //页面返回信息
        String nickname = "Unkown";
        //json处理工具
        ObjectMapper objectMapper = new ObjectMapper();
        //请求执行工具
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //请求发送信息
        HttpPost httppost;
        HttpEntity reqEntity;
        CloseableHttpResponse responseEntity;
        //请求返回值处理需要的临时变量
        BufferedReader reader;
        StringBuilder tempSB;
        String tempLine;
        //处理结果
        Map<String, String> map;

        try {
            Map<String, String> param = objectMapper.readValue(jsonFile, Map.class);
            String codeStr = code;
            //如果code或json信息为空直接退出
            if (codeStr != null && param != null) {
                //第一次请求
                httppost = new HttpPost("https://graph.qq.com/oauth2.0/token");
                reqEntity = MultipartEntityBuilder.create()
                        .addPart("code", new StringBody(codeStr, ContentType.TEXT_PLAIN))
                        .addPart("client_id", new StringBody(param.get("qq_id"), ContentType.TEXT_PLAIN))
                        .addPart("client_secret", new StringBody(param.get("qq_secret"), ContentType.TEXT_PLAIN))
                        .addPart("redirect_uri", new StringBody(param.get("qq_url"), ContentType.TEXT_PLAIN))
                        .addPart("grant_type", new StringBody("authorization_code", ContentType.TEXT_PLAIN))
                        .build();
                httppost.setEntity(reqEntity);
                responseEntity = httpclient.execute(httppost);
                //从第一次请求的返回值中拿到token
                String accessToken = null;
                tempSB = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(responseEntity.getEntity().getContent()));
                while ((tempLine = reader.readLine()) != null) {
                    tempSB.append(tempLine);
                }
                String[] results = tempSB.toString().split("&");
                for (String result : results) {
                    String[] tmp = result.split("=");
                    if (tmp.length == 2 && "access_token".equals(tmp[0])) {
                        accessToken = tmp[1];
                    }
                }
                //如果token拿不到直接退出
                if (accessToken != null) {
                    //第二次请求
                    httppost = new HttpPost("https://graph.qq.com/oauth2.0/me");
                    reqEntity = MultipartEntityBuilder.create()
                            .addPart("access_token", new StringBody(accessToken, ContentType.TEXT_PLAIN))
                            .build();
                    httppost.setEntity(reqEntity);
                    responseEntity = httpclient.execute(httppost);
                    //从第二次请求的返回值中拿到openid
                    tempSB = new StringBuilder();
                    reader = new BufferedReader(new InputStreamReader(responseEntity.getEntity().getContent()));
                    while ((tempLine = reader.readLine()) != null) {
                        tempSB.append(tempLine);
                    }
                    map = objectMapper.readValue(tempSB.toString().substring(tempSB.toString().indexOf("{"), tempSB.toString().indexOf("}") + 1), Map.class);
                    //如果openid拿不到则直接退出
                    if (map.get("client_id") != null && map.get("openid") != null) {
                        //第三次请求
                        httppost = new HttpPost("https://graph.qq.com/user/get_user_info");
                        reqEntity = MultipartEntityBuilder.create()
                                .addPart("access_token", new StringBody(accessToken, ContentType.TEXT_PLAIN))
                                .addPart("openid", new StringBody(map.get("openid"), ContentType.TEXT_PLAIN))
                                .addPart("oauth_consumer_key", new StringBody(map.get("client_id"), ContentType.TEXT_PLAIN))
                                .build();
                        httppost.setEntity(reqEntity);
                        responseEntity = httpclient.execute(httppost);
                        //从第三次请求的返回值中拿到用户信息(nickname)
                        tempSB = new StringBuilder();
                        reader = new BufferedReader(new InputStreamReader(responseEntity.getEntity().getContent()));
                        while ((tempLine = reader.readLine()) != null) {
                            tempSB.append(tempLine);
                        }
                        map = objectMapper.readValue(tempSB.toString(), Map.class);
                        nickname = map.get("nickname");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nickname;
    }
}
