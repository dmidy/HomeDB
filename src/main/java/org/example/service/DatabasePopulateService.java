package org.example.service;


import org.example.db.Database;
import org.example.service.SqlScriptExecutor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class DatabasePopulateService {
    public static void main(String[] args){
        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlScript = SqlScriptExecutor.readSqlScript("src/main/resources/sql/populate_db.sql");
            SqlScriptExecutor.executeSqlScript(connection, sqlScript);

            System.out.println("Success.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
