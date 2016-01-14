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

	public String doPostRequest(String url, Map<String, String> requestHeadParams, Map<String, Object> requestBodyParams) {
        String result = null;
		try {
            LoggerBasara.info(this.getClass(), "http tool do POST http request...");
            HttpPost httpPost = new HttpPost(url);
            if (!MapBasara.isNullOrEmpty(requestHeadParams)){
                for (String key : requestHeadParams.keySet()) {
                    httpPost.setHeader(key, requestHeadParams.get(key));
                }
            }
			if (!MapBasara.isNullOrEmpty(requestBodyParams)) {
				MultipartEntityBuilder builder = MultipartEntityBuilder.create();
				for (String key : requestBodyParams.keySet()) {
                    //目前支持String参数的调用
					builder.addPart(key, new StringBody((String)requestBodyParams.get(key), ContentType.TEXT_PLAIN));
				}
				HttpEntity entity = builder.build();
				httpPost.setEntity(entity);
			}
            result = printResponseAnd2StringResult(client.execute(httpPost));
		} catch (IOException e) {
			LoggerBasara.error(this.getClass(), e.getMessage());
		}
        return result;
	}

    public String doGetRequest(String url, Map<String, String> requestParams){
        HttpGet httpGet = new HttpGet(buildRequestUrl(url, requestParams));
        String result = null;
        try {
            LoggerBasara.info(this.getClass(), "http tool do GET http request...");
            result = printResponseAnd2StringResult(client.execute(httpGet));
        }catch (IOException e){
            LoggerBasara.error(this.getClass(), e.getMessage());
        }
        return result;
    }

    private String buildRequestUrl(String url, Map<String, String> requestParams){
        StringBuilder sb = new StringBuilder(url);
        if (!MapBasara.isNullOrEmpty(requestParams)){
            int i = 0;
            int size = requestParams.size() - 1;
            for (String key : requestParams.keySet()) {
                if (i == 0 && !url.contains("?")){
                    sb.append("?");
                }else if (i == 0 && url.contains("?") && url.indexOf("?") > url.indexOf("=")){
                    sb.append("&");
                }
                sb.append(key).append("=").append(requestParams.get(key));
                if (i != size){
                    sb.append("&");
                }
                i++;
            }
        }
        return sb.toString();
    }

    private String printResponseAnd2StringResult(CloseableHttpResponse response) throws IOException{
        String result = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))){
            LoggerBasara.info(this.getClass(), "statusCode: ===== {}", String.valueOf(response.getStatusLine().getStatusCode()));
            LoggerBasara.info(this.getClass(), "allHeads: ===== {}", Arrays.toString(response.getAllHeaders()));
            StringBuilder sb = new StringBuilder();
            String tempLine;
            while ((tempLine = reader.readLine()) != null) {
                sb.append(tempLine);
            }
            LoggerBasara.info(this.getClass(), "entity: ===== {}", result = sb.toString());
            LoggerBasara.info(this.getClass(), "end of http request...");
        }catch (IOException e){
            LoggerBasara.error(this.getClass(), e.getMessage());
        }finally {
            LoggerBasara.info(this.getClass(), "close response...");
            response.close();
        }
        return result;
    }
}
