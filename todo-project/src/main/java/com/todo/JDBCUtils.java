package com.todo;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";  // SID 기반
            String user = "system";     // 예: system 또는 만든 사용자
            String password = "12345"; // 비밀번호

            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
