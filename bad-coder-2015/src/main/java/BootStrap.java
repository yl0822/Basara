import com.alibaba.fastjson.JSON;
import tools.netease.basara.ChristmasSockVO;
import tools.netease.basara.MobileChristmasUnitVO;

import java.util.*;

/**
 * @author long.yl.
 */
public class BootStrap {
    public static void main(String[] args) {
        String jasonUnitContent = "{\"list\":[{\"id\":\"0\",\"imgUrl\":\"http://paopao.nosdn.127.net/250851d4-825c-4929-b302-8178f94d52e2\",\"linkUrl\":\"http://m.xiupin.com/m/activity/stage?date=20151224&sessionId=0\"},{\"id\":\"0\",\"imgUrl\":\"http://paopao.nosdn.127.net/efb9be3f-c67e-4440-876e-c200f4634ee5\",\"linkUrl\":\"http://m.xiupin.com/m/activity/stage?date=20151224&sessionId=17\"},{\"id\":\"0\",\"imgUrl\":\"http://paopao.nosdn.127.net/f336c407-9c81-4115-95f6-6f4e17f38ea9\",\"linkUrl\":\"vstore-link://pagestr=16?statis=APPSYJDT3&itemId=12013\"},{\"id\":\"0\",\"imgUrl\":\"http://paopao.nosdn.127.net/49b6950e-cfe3-49d0-bb8d-1e6ed0f31d7d\",\"linkUrl\":\"vstore-link://pagestr=16?statis=APPSYJDT4&itemId=46\"},{\"id\":\"0\",\"imgUrl\":\"http://paopao.nosdn.127.net/541581d0-f970-483b-8454-9e3365c2784e\",\"linkUrl\":\"http://m.xiupin.com/m/activity/stage?date=20151224&sessionId=15\"}]}";
        MobileChristmasUnitVO christmasUnitVO = JSON.parseObject(jasonUnitContent, MobileChristmasUnitVO.class);
        for (MobileChristmasUnitVO.Unit unit1 : christmasUnitVO.getList()) {
            //限制3：链接由http开头
            if (unit1.getLinkUrl().startsWith("http://")){
                long userId = 111;
                String actId;
                if (userId > 0){
                    actId = "aaa";
//                    actId = lotteryService.getActIdByUserId(userId);
                    if (actId == null){
//                        LotteryUser lotteryUser = lotteryService.addUser(userId);
//                        actId = lotteryUser.getActId();
                    }
                }else {
                    actId = "5a6sf556das4gf564sd58f";
                }
                unit1.setLinkUrl(unit1.getLinkUrl() + "&actId=" + actId);
            }
        }
        jasonUnitContent = JSON.toJSONString(christmasUnitVO);
        System.out.println(jasonUnitContent);
    }
}
