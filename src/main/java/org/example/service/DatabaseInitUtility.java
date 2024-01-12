package org.example.service;

import org.example.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitUtility {
    public static PreparedStatement initStatementClient() {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO client (ID, Name) VALUES (?,?)");
            return statement;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static PreparedStatement initStatementWorker() {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (?,?,?,?,?)");
            return statement;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static PreparedStatement initStatementProject() {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?,?,?,?)");
            return statement;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static PreparedStatement initStatementProjectWorker() {
        try {
            Connection connection = Database.getInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?,?)");
            return statement;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
