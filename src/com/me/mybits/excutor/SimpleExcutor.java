package com.me.mybits.excutor;

import com.me.mybits.entity.User;

import java.sql.*;

public class SimpleExcutor implements Excutor {
    @Override
    public <T> T query(String sql, Object parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(parameter));
            set = preparedStatement.executeQuery();
            User u = new User();
            while(set.next()){
                u.setName(set.getString(1));
            }
            return (T) u;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    private Connection getConnection() {
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/data-analysis?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="root";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
