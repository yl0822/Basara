package com.basara.mainpage;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author long.yl.
 * @Date 2016/6/28
 */
@RestController
@RequestMapping("/m")
public class MobileMainPageController {

    @Autowired
    MobileMainPageService mobileMainPageService;

    @RequestMapping(value = "/cms", method = RequestMethod.GET)
    public String getIndex() {
        return "unit";
    }

    /**
     * 获取后台配置的单元列表（面向APP）
     */
    @RequestMapping(value = "/getMutativeUnitList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public BaseJsonVO getMutativeUnitList(@RequestParam(value = "scenicId") String scenicId,
                                          @RequestParam(value = "pageIndex", required = false) String pageIndex,
                                          HttpServletRequest request, HttpServletResponse response) {
        String deviceType = getAppInfoFromHeader(request.getHeader("AppInfo"), "os");
        if (StringUtils.isEmpty(pageIndex)) {
            return mobileMainPageService.getMutativeUnitList(Integer.valueOf(scenicId), 0, deviceType);
        } else {
            return mobileMainPageService.getMutativeUnitList(Integer.valueOf(scenicId),
                    Integer.valueOf(pageIndex), deviceType);
        }
    }

    private String getAppInfoFromHeader(String header, String name) {
        if (StringUtils.isBlank(header)) {
            return null;
        }
        String[] headerItems = StringUtils.split(header, "&");
        if (headerItems == null) {
            return null;
        }
        for (String item : headerItems) {
            String[] itemValues = StringUtils.split(item, "=");
            if (itemValues != null && itemValues.length == 2 && itemValues[0].equalsIgnoreCase(name)) {
                return itemValues[1];
            }
        }
        return null;
    }

}
