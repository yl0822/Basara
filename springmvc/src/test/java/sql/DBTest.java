package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
public class DBTest {
    public static void main(String[] args) throws Throwable {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://10.120.153.150/yldb", "vstoredev", "vstoredev");
        ResultSet set = connection.createStatement().executeQuery("select id from TB_Content_CloudSong");
        long id = 0;
        while (set.next()) {
            id = set.getLong(1);
        }
        System.out.println(id);
        connection.close();
    }
}
