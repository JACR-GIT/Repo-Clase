package com.proyectojdbc.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static String URL = "jbdc:oracle:thin:@localhost:1521:XE";
    private static String USERNAME = "C##PRUEBASPROYCTO";
    private static String PASSWORD = "123456";

    private static ConnectionManager instance;
    private ConnectionManager() {
        Properties props = new Properties();

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");
            if(is == null){
                throw new FileNotFoundException("config.properties no encontrado");
            }
            props.load(is);
            URL = props.getProperty("db.url");
            USERNAME = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

}
