package videocenter.dao;

import videocenter.model.base.BaseRequest;
import videocenter.model.base.BaseResponse;

/**
 * @author long.yl.
 * @Date 2016/5/9
 */
public interface BaseDao<REQ extends BaseRequest, RESP extends BaseResponse> {
	RESP excute(REQ req) throws Exception;
}
