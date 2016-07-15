package videocenter.model.response;

import videocenter.model.base.BaseResponse;

/**
 * @author long.yl.
 * @Date 2016/5/9
 */
public class VideoUploadResponse extends BaseResponse {

    private static final long serialVersionUID = 6830573362707815780L;

    private int code;

    private String xNosToekn;

    private String bucket;

    private String object;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getxNosToekn() {
        return xNosToekn;
    }

    public void setxNosToekn(String xNosToekn) {
        this.xNosToekn = xNosToekn;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
