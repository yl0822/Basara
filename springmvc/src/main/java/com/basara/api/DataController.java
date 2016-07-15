package com.basara.api;

import com.alibaba.fastjson.JSON;
import com.basara.dao.CloudSongDao;
import com.redis.dc.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by long.yl on 2016/7/1.
 */
@Controller
public class DataController {

    @Autowired
    CloudSongDao cloudSongMapper;

    @Autowired
    Client hashClient;

    @RequestMapping("/song/get/{id}")
    public
    @ResponseBody
    String getSougDetail(@PathVariable("id") long id) {
        return JSON.toJSONString(cloudSongMapper.getById(id));
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println(hashClient.getDesc());
        return "index";
    }

    @RequestMapping("/redis/get/{key}")
    public String index(@PathVariable("key") String key) {
        try {
            System.out.println(hashClient.get("redis", key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping("/login")
    public ModelAndView login(String username, String password) {
        System.out.println("username: " + username + " and password: " + password);
        if ("yl".equals(username) && "1234".equals(password)) {
            System.out.println("login success!");
            Map<String, Object> model = new HashMap<>();
            model.put("username", username);
            return new ModelAndView("success", model);
        } else {
            System.out.println("login falied!");
            return new ModelAndView("index");
        }
    }

}
