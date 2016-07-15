package com.basara.mainpage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by hzlifangjian on 2016/6/15.
 */
public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtils() {
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        boolean isJackson = true;
        Object t = null;

        try {
            if (!isJackson && (!StringUtils.isNotBlank(jsonString) || !clazz.isEnum()
                    || clazz.getAnnotation(JsonDeserialize.class) == null)) {
                t = JSON.parseObject(jsonString, clazz);
            } else {
                t = mapper.readValue(jsonString, clazz);
            }
        } catch (JSONException var5) {
            logger.error("JSONException", var5);
        } catch (IOException var6) {
            logger.error("IOException", var6);
        }

        return (T) t;
    }

    public static Object fromJson(String jsonString) {
        Object obj = null;

        try {
            obj = JSON.parse(jsonString);
        } catch (JSONException var3) {
            logger.error("JSONException", var3);
        }

        return obj;
    }

    public static <T> List<T> parseArray(String jsonString, Class<T> clazz) {
        List list = null;

        try {
            list = JSON.parseArray(jsonString, clazz);
        } catch (JSONException var4) {
            logger.error("JSONException", var4);
        }

        return list;
    }

    public static String toJson(Object obj) {
        return toJson(obj, new SerializerFeature[0]);
    }

    public static String toJson(Object obj, SerializerFeature... features) {
        boolean isJackson = true;
        String ret = null;

        try {
            if (!isJackson && (obj == null || !obj.getClass().isEnum()
                    || obj.getClass().getAnnotation(JsonFormat.class) == null)) {
                ret = JSON.toJSONString(obj, features);
            } else {
                ret = mapper.writeValueAsString(obj);
            }
        } catch (JSONException var5) {
            logger.error("JSONException", var5);
        } catch (IOException var6) {
            logger.error("IOException", var6);
        }

        return ret;
    }

    public static String toJsonTabAsSpecial(Object obj) {
        String ret = null;

        try {
            ret = JSON.toJSONString(obj, new SerializerFeature[]{SerializerFeature.WriteTabAsSpecial});
        } catch (JSONException var3) {
            logger.error("JSONException", var3);
        }

        return ret;
    }

    public static JSONObject toJSONObject(String text) {
        JSONObject jsonObject = null;

        try {
            jsonObject = JSON.parseObject(text);
        } catch (JSONException var3) {
            logger.error("JSONException", var3);
        }

        return jsonObject;
    }

}
