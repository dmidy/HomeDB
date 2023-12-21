package org.example.dao;

import org.example.db.Database;
import org.example.model.MaxDurationProject;
import org.example.service.SqlScriptExecutor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaxDurationProjectDao {

    private static final String FIND_MAX_DURATION_PROJECT_QUERY_FILE_PATH =
            "src/main/resources/sql/find_longest_project.sql";

    public List<MaxDurationProject> findMaxDurationProject() {
        List<MaxDurationProject> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlScript = SqlScriptExecutor.readSqlScript(FIND_MAX_DURATION_PROJECT_QUERY_FILE_PATH);

            try (PreparedStatement statement = connection.prepareStatement(sqlScript);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    MaxDurationProject project = mapResultSetToMaxDurationProject(resultSet);
                    result.add(project);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private MaxDurationProject mapResultSetToMaxDurationProject(ResultSet resultSet) throws SQLException {
        MaxDurationProject maxDurationProject = new MaxDurationProject();

        maxDurationProject.setName(resultSet.getString("name"));
        maxDurationProject.setMonthCount(resultSet.getInt("monthCount"));

        return maxDurationProject;
    }
}