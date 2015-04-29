package ro.teamnet.zth.api.database;

import ro.teamnet.zth.api.database.DProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private DBManager() {
        throw new UnsupportedOperationException();
    }
    public static final String CONNECTION_STRING = "jdbc:mysql://" + DProperties.IP + "/" + DProperties.SCHEMA;
    private static void registerDriver() {
        try {
            Class.forName(DProperties.DRIVER_CLASS);  //incarci driver-ul
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        registerDriver();
        try {
            con = DriverManager.getConnection(CONNECTION_STRING, DProperties.USER, DProperties.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}