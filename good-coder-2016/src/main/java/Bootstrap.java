import com.alibaba.fastjson.JSON;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Larry .Yang
 * on 16/3/25 13:49
 * Package: parent_PACKAGE_NAME
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();
        // 保留一个月
        calendar.add(Calendar.DATE, -30);
        String time1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(calendar.getTime());
        calendar.add(Calendar.DATE, 1);
        String time2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(calendar.getTime());
        String sql = "SELECT Id FROM Musician_SongAudit where db_create_time < '"+time2+"' and db_create_time > '" + time1 +"'";
        System.out.println(sql);
    }
}

