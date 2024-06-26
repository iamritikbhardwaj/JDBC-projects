package queries;

import ConnectionProvider.ConnectionProvider;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args) {

        try {
            String q = "insert into image (images) value(?)";
            Connection c = ConnectionProvider.getConnection();
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate("create table images");
            PreparedStatement pstmt = c.prepareStatement(q);
//            FileInputStream fis = new FileInputStream("/home/rishi/Documents/Sprin Projects/JDBC practice/JDBCimageInsert/src/img.jpg");
//            pstmt.setBinaryStream(1,fis, fis.available());
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            pstmt.setBinaryStream(1,fis,fis.available());
            pstmt.executeUpdate();
            System.out.println("Image inserted");
            c.close();
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}