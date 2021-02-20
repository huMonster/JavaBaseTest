package com.base.test;

import java.sql.*;

public class CloseTest {
    public static void main(String[] args) throws ClassNotFoundException {

        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        try (//2.获得数据库链接
             Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/common", "root", "123456");
             //3.通过数据库的连接操作数据库，实现增删改查
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from new_table")
        ) {
            //4.处理数据库的返回结果
            while (rs.next()) {
                System.out.println(rs.getString("id") + " " + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
