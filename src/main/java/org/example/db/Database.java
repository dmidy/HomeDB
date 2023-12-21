package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
        private String JDBC_URL = "jdbc:postgresql://192.168.88.139:5432/postgres";
        private String USERNAME = "postgres";
        private String PASSWORD = "12344321";
        private static Database instance;

        private Database(){

        }
        public static synchronized Database getInstance() {
                if (instance == null) {
                        instance = new Database();
                }
                return instance;
        }
        public Connection getConnection() throws SQLException {
                return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        }

}
