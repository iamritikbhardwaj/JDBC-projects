package queries.Update;

import ConnectionProvider.ConnectionProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateJdbc {
    public static void main(String[] args) {
        Connection con = ConnectionProvider.getConnection();
        String q = "update table set tname=?, tcity=? where tid=?";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            PreparedStatement pstmt = con.prepareStatement(q);
            System.out.println("Enter name");
            String name = br.readLine();
            System.out.println("Enter city");
            String city = br.readLine();
            System.out.println("Enter Id");
            int id = br.read();
            pstmt.setString(1,name);
            pstmt.setString(2,city);
            pstmt.setInt(3,id);
            pstmt.executeUpdate();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
