package org.example.dao;

import org.example.db.Database;
import org.example.model.TopClientProjects;
import org.example.service.SqlScriptExecutor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopClientProjectsDao {

    private static final String FIND_TOP_CLIENT_PROJECTS_QUERY_FILE_PATH =
            "src/main/resources/sql/find_max_projects_client.sql";

    public List<TopClientProjects> findTopClientProjects() {
        List<TopClientProjects> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlScript = SqlScriptExecutor.readSqlScript(FIND_TOP_CLIENT_PROJECTS_QUERY_FILE_PATH);

            try (PreparedStatement statement = connection.prepareStatement(sqlScript);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    TopClientProjects topClientProjects = mapResultSetToTopClientProjects(resultSet);
                    result.add(topClientProjects);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private TopClientProjects mapResultSetToTopClientProjects(ResultSet resultSet) throws SQLException {
        TopClientProjects topClientProjects = new TopClientProjects();

        topClientProjects.setName(resultSet.getString("NAME"));
        topClientProjects.setProjectCount(resultSet.getInt("ProjectCount"));

        return topClientProjects;
    }
}