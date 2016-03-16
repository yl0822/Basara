package com.basara.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
@Controller
@RequestMapping("/springmvc")
public class BaseController {

    private static Logger logger = LoggerFactory.getLogger(TextPostController.class);

    @RequestMapping("/")
    public void index(){
        logger.info("你过来啊啊啊啊啊啊啊啊啊啊啊！");
    }
}
