package videocenter.model.base;

import java.io.Serializable;

/**
 * @author long.yl.
 * @Date 2016/5/9
 */
public abstract class BaseRequest implements Serializable {
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
