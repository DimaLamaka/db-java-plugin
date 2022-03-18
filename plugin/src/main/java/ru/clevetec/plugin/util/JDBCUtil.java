package ru.clevetec.plugin.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Properties properties = getProperties();
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(properties.getProperty("driver"));

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream("plugin/src/main/resources/jdbc.properties")) {
            properties.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
