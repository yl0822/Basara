package videocenter.model.request;

import videocenter.model.base.BaseRequest;

/**
 * @author long.yl.
 * @Date 2016/5/9
 */
public class VideoUploadRequest extends BaseRequest {
    private static final long serialVersionUID = -6713616956990131814L;

    private String originFileName;

    private String userFileName;

    private int typeId;

    private int presetId;

    private String callbackUrl;

    private String description;

    public String getUserFileName() {
        return userFileName;
    }

    public void setUserFileName(String userFileName) {
        this.userFileName = userFileName;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getPresetId() {
        return presetId;
    }

    public void setPresetId(int presetId) {
        this.presetId = presetId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
