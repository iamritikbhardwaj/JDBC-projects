package ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static Connection con;
    private static final String url = "jdbc:mysql://";
    private static final String user = "";
    private static final String password = "";

    public static Connection getConnection() throws RuntimeException {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }
}
