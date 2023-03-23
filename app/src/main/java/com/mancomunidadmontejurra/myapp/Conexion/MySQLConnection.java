package com.mancomunidadmontejurra.myapp.Conexion;

import java.sql.*;

public class MySQLConnection {
    private static final String DB_HOST = "192.0.0.141";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "mancomunidad";
    private static final String DB_USER = "admin";
    private static final String DB_PASS = "root";

    public static Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String connectionString = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME+"?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        return DriverManager.getConnection(connectionString, DB_USER, DB_PASS);
    }
}
