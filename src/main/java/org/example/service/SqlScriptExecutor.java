package org.example.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlScriptExecutor {

    public static String readSqlScript(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
    }

    static void executeSqlScript(Connection connection, String sqlScript) throws SQLException {
        String[] queries = sqlScript.split(";");

        try (Statement statement = connection.createStatement()) {
            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    statement.execute(query);
                }
            }
        }
    }
}