package http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sql.base.BaseTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class HttpTest {

    private static Logger logger = LoggerFactory.getLogger(HttpTest.class);

    HttpClient client = null;
    BufferedReader reader = null;

    @Before
    public void init(){
        if (client == null){
            client = HttpClientBuilder.create().build();
        }
    }

    @After
    public void destroy(){
        System.out.println("资源关闭....");
        try {
            reader.close();
        }catch (Exception e){
            logger.error("资源关闭出错");
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testGet(){
        HttpGet getRequest = new HttpGet("http://localhost:8080/text/get/4");
        HttpResponse response = null;
        try {
           response = client.execute(getRequest);
        }catch (Exception e){
            logger.error("发送请求出错");
            logger.error(e.getMessage());
        }
        if (response == null){
            logger.error("无法获取response");
        }else {
            try {
                reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuilder sb = new StringBuilder();
                String temp;
                while((temp = reader.readLine()) != null){
                    sb.append(temp);
                }
                System.out.println(sb.toString());
            }catch (Exception e){
                logger.error("读取response出错");
                logger.error(e.getMessage());
            }
        }
    }
}
