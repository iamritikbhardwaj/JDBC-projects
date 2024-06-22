import java.sql.*;
import java.io.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://";
        String userid = "";
        String password = "";
        // Query to create table
//        String q= "create table empData (eID int(20) primary key auto_increment, eName varchar(100) not null, eCity varchar(200))";
        // Insert data into the table
//        String q = "insert into empData (eName, eCity) values (?, ?)";
        String q = "drop table empData";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url, userid, password);
            System.out.println("Database Connected");
            // stmt to execute query like create, drop etc.
            Statement stmt= con.createStatement();
            stmt.executeUpdate(q);
            // create prepared statement.
            PreparedStatement pstmt = con.prepareStatement(q);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name of the employee");
            String name = br.readLine();
            System.out.println("Enter city of the employee");
            String city = br.readLine();
            pstmt.setString(1,name);
            pstmt.setString(2, city);
            pstmt.executeUpdate();

            System.out.println("Data Inserted");
//            System.out.println("Data dropped");
            con.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
