package com.flysky.study.mybatis.jdbc;

import org.junit.Test;

import java.sql.*;

public class JdbcTest {

    @Test
    public void testGetConnectByDriverManager() throws SQLException {
        String url="jdbc:mysql://10.1.1.11:3306/flysky";
        String user="root";
        String password="123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from sys_user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("resultSet.getObject(1) = " + resultSet.getObject(1));
        }
    }
}
