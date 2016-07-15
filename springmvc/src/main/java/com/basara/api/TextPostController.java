package com.basara.api;

import com.basara.service.TextPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
@Controller
@RequestMapping("/text")
public class TextPostController {
    private static Logger logger = LoggerFactory.getLogger(TextPostController.class);

    @Autowired
    TextPostService textPostService;

    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String deleteTextPost(@PathVariable("id") long id) {
        return textPostService.deleteTestPostById(id) ? "删除成功" : "删除失败";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String getTextPost(@PathVariable("id") long id) {
        return textPostService.getTestPostById(id).toString();
    }
}
