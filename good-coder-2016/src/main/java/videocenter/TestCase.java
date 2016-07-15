package videocenter;

import org.junit.Assert;
import org.junit.Test;
import videocenter.dao.BaseDao;
import videocenter.dao.VideoUploadDao;
import videocenter.dao.util.Constants;
import videocenter.model.request.VideoUploadRequest;
import videocenter.model.response.VideoUploadResponse;

/**
 * @author long.yl.
 * @Date 2016/5/9
 */
public class TestCase {

    @Test
    public void videoUpload() {
        BaseDao<VideoUploadRequest, VideoUploadResponse> dao = new VideoUploadDao();
        VideoUploadRequest request = new VideoUploadRequest();
        VideoUploadResponse response;
        request.setUrl(Constants.UPLOAD_INIT_URL);
        request.setDescription("");
        try {
            response = dao.excute(request);
            if (response != null) {
                System.out.println(response.getCode());
                Assert.assertEquals(703, response.getCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
