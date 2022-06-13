package com.flysky.study.dbrider;

import com.github.database.rider.core.api.connection.ConnectionHolder;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class TestA {
    @Test
    public void should_run() {
        System.out.println("test");
    }

    @Test
    public void should_() throws SQLException {
        DataSource ds = new DataSource() {
            @Override
            public Connection getConnection() throws SQLException {
                return null;
            }

            @Override
            public Connection getConnection(String username, String password) throws SQLException {
                return null;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }

            @Override
            public PrintWriter getLogWriter() throws SQLException {
                return null;
            }

            @Override
            public void setLogWriter(PrintWriter out) throws SQLException {

            }

            @Override
            public void setLoginTimeout(int seconds) throws SQLException {

            }

            @Override
            public int getLoginTimeout() throws SQLException {
                return 0;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        };
        a(ds::getConnection);
        b(ds::getConnection);
    }

    public void a(ConnectionHolder holder) {
        try {
            System.out.println(holder.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void b(MyConnectionHolder holder) throws SQLException {
        System.out.println(holder);
    }

    public interface MyConnectionHolder{
        Connection getConnection() throws SQLException;
    }
}