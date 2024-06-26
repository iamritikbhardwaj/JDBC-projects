package queries.select;

import ConnectionProvider.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectData {
    public static void main(String[] args) {
        Connection con = ConnectionProvider.getConnection();
        String u = "select * from students";
        try {
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(u);
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);
                System.out.println(id + ":" + name + ":" + city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
