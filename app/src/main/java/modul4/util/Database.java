package modul4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String DATABASE = "prak-pbo";
    public static final String PORT = "5432";
    public static final String HOST = "localhost";
    public static final String USER = "developer";
    public static final String PASSWORD = "developer";
    public static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;

    public static Connection connect() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to PostgreSQL successfully!");
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        return conn;
    }

}
