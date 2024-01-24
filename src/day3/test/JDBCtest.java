package day3.test;

import day3.entity.User;

import java.sql.*;

/**
 * @author yi xian
 * @description
 * @date 2023/6/7 11:09
 */
public class JDBCtest {
    public static void main(String[] args) {
        // 导入驱动包jar
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获得连接
            String url = "jdbc:mysql://localhost:3306/suibian?serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url,"root","your_password");
            System.out.println(conn);

            // 执行SQL语句 PreparedStatement
            String sql = "select * from suibian where num = ? and PASSWORD = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,"1001");
            stmt.setString(2,"1234");
            ResultSet resultSet = stmt.executeQuery();

            // 处理结果集 ResultSeT
            User user = new User();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
