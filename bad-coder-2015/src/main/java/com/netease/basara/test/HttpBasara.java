package com.netease.basara.test;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import tools.netease.basara.LoggerBasara;
import tools.netease.basara.MapBasara;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * @author long.yl.
 * @Date 2016/1/14
 */
public class HttpBasara {

    CloseableHttpClient client;

    public HttpBasara(){
        init();
    }

    private void init(){
        LoggerBasara.info(this.getClass(), "initing http tool...");
        client = HttpClients.createDefault();
    }

	public static void main(String[] args) {
		HttpBasara basara = new HttpBasara();
        Map<String, String> requestHeadParams = new HashMap<>();
        requestHeadParams.put("token", "389CB8CFC156ECD9384E600897EB2F6319E55051F7A5B1F0C7C51E1357E897C8AC4117F927BD2E934B5D01E1F0403C15B4C1FED00B2111DE700F552F39962707|16DD788F9898C9010D339F53DD73B253D27642CE6CF1CA7A11831B017A543036E4EDD3253746BCE7E7983D77D5F6412B");
        basara.doPostRequest("http://m.paopao.163.com/m/v2/editAccount", requestHeadParams, null);
//        basara.doGetRequest("http://m.paopao.163.com/m/v2/getRecmSearchKey");
    }

	private void doPostRequest(String url, Map<String, String> requestHeadParams, Map<String, String> requestBodyParams) {
        LoggerBasara.info(this.getClass(), "http tool do POST http request...");
		try {
			HttpPost httpPost = new HttpPost(url);
            if (!MapBasara.isNullOrEmpty(requestHeadParams)){
                for (String key : requestHeadParams.keySet()) {
                    httpPost.setHeader(key, requestHeadParams.get(key));
                }
            }
			if (!MapBasara.isNullOrEmpty(requestBodyParams)) {
				MultipartEntityBuilder builder = MultipartEntityBuilder.create();
				for (String key : requestBodyParams.keySet()) {
					builder.addPart(key, new StringBody(requestBodyParams.get(key), ContentType.TEXT_PLAIN));
                    if (key.equals("avatar")){
                        builder.addBinaryBody(key, new FileInputStream(new File("")));
                    }
				}
				HttpEntity entity = builder.build();
				httpPost.setEntity(entity);
			}
            printResponseMainMessage(client.execute(httpPost));
		} catch (IOException e) {
			LoggerBasara.error(this.getClass(), e.getMessage());
		}
	}

    private void doGetRequest(String url){
        HttpGet httpGet = new HttpGet(url);
        try {
            LoggerBasara.info(this.getClass(), "http tool do GET http request...");
            printResponseMainMessage(client.execute(httpGet));
        }catch (IOException e){
            LoggerBasara.error(this.getClass(), e.getMessage());
        }
    }

    private void printResponseMainMessage(CloseableHttpResponse response) throws IOException{
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))){
            LoggerBasara.info(this.getClass(), "statusCode: ===== {}", String.valueOf(response.getStatusLine().getStatusCode()));
            LoggerBasara.info(this.getClass(), "allHeads: ===== {}", Arrays.toString(response.getAllHeaders()));
            StringBuilder sb = new StringBuilder();
            String tempLine;
            while ((tempLine = reader.readLine()) != null) {
                sb.append(tempLine);
            }
            LoggerBasara.info(this.getClass(), "entity: ===== {}", sb.toString());
            LoggerBasara.info(this.getClass(), "end of http request...");
        }catch (IOException e){
            LoggerBasara.error(this.getClass(), e.getMessage());
        }finally {
            LoggerBasara.info(this.getClass(), "close response...");
            response.close();
        }
    }
}
