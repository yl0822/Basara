package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author long.yl.
 * @Date 2016/6/23
 */
public class JdbcUtil {
    public static void main(String[] args) throws Exception {
        Class.forName("mysql.jdbc.driver.Driver");
        Connection conn = DriverManager.getConnection("");
        PreparedStatement statement = conn.prepareStatement("");
        ResultSet set = statement.getResultSet();
        while (set.next()) {
            String str = set.getString(1);
        }
    }
}
