import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Larry .Yang
 * on 16/3/25 13:49
 * Package: parent_PACKAGE_NAME
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        List<Student> list = new ArrayList<>();
        list.add(new Student("aaa", 23));
        list.add(new Student("bbb", 22));
        list.add(new Student("ccc", 31));
        list.add(new Student("ddd", 34));
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "aaaaaa");
        map.put("bbb", "bbbbbb");
        map.put("ccc", "cccccc");
        map.put("ddd", "dddddd");
        Map<String, Object> result = new HashMap<>();
        result.put("result", map);
        Map<String, Object> result2 = new HashMap<>();
        result2.put("result", list);
//        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(result2));
    }
}
class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
