package videocenter.dao;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import videocenter.dao.util.HeaderHelper;
import videocenter.model.request.VideoUploadRequest;
import videocenter.model.response.VideoUploadResponse;

/**
 * @author long.yl.
 * @Date 2016/5/9
 */
public class VideoUploadDao implements BaseDao<VideoUploadRequest, VideoUploadResponse> {
    private final Logger logger = LoggerFactory.getLogger(VideoUploadDao.class);

    private HttpClient httpClient;

    public VideoUploadDao() {
        httpClient = HttpClientBuilder.create().build();
    }

    @Override
    public VideoUploadResponse excute(VideoUploadRequest request) throws Exception {
        HttpPost httpPost = new HttpPost(request.getUrl());
        HeaderHelper.addHeader(httpPost);
        // ��������Ĳ���
        StringEntity params = new StringEntity(JSON.toJSONString(request));
        httpPost.setEntity(params);
        logger.info(JSON.toJSONString(request));

        // ִ������
        HttpResponse response = httpClient.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");

        // ��ӡִ�н��
        logger.info(result);
        return JSON.parseObject(result, VideoUploadResponse.class);
    }
}
