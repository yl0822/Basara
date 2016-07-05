package com.basara.mainpage;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzlifangjian on 2016/6/12.
 */
public class ReflectUtils {

    private static final Logger logger = LoggerFactory.getLogger(ReflectUtils.class);

    private ReflectUtils() {
    }

    public static <T1, T2> void convertObj(T1 des, T2 sou) {
        if (des != null && sou != null) {
            Class desClass = des.getClass();
            Class souClass = sou.getClass();

            List<Field> desFieldList = new ArrayList<>();
            getFieldListByClass(desClass, desFieldList);

            if (!CollectionUtils.isEmpty(desFieldList)) {
                for (Field field : desFieldList) {
                    Class fieldTypeClass = field.getType();
                    String fieldName = field.getName();
                    String getMethodPrefix = "get";
                    String setMethodPrefix = "set";
                    String methodNameSuffix = fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1, fieldName.length());
                    String getMethodName = getMethodPrefix + methodNameSuffix;
                    String setMethodName = setMethodPrefix + methodNameSuffix;
                    try {
                        Method methodOfGet = souClass.getMethod(getMethodName, new Class[0]);
                        Method methodOfSet = desClass.getMethod(setMethodName, new Class[]{fieldTypeClass});
                        Object value = methodOfGet.invoke(sou, new Object[0]);
                        methodOfSet.invoke(des, new Object[]{value});
                    } catch (Exception e) {
                        logger.debug("");
                    }
                }
            }
        }
    }

    private static void getFieldListByClass(Class c, List<Field> list) {
        Field[] fields = c.getDeclaredFields();
        if (!ArrayUtils.isEmpty(fields)) {
            for (Field field : fields) {
                list.add(field);
            }
        }
        if (c.getSuperclass() == null) {
            return;
        }
        getFieldListByClass(c.getSuperclass(), list);
    }

}
