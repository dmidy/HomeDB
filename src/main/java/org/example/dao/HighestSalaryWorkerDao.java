package org.example.dao;

import org.example.db.Database;
import org.example.model.HighestSalaryWorker;
import org.example.service.SqlScriptExecutor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HighestSalaryWorkerDao {

    private static final String FIND_HIGHEST_SALARY_WORKER_QUERY_FILE_PATH =
            "src/main/resources/sql/find_max_salary_worker.sql";

    public List<HighestSalaryWorker> findHighestSalaryWorker() {
        List<HighestSalaryWorker> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlScript = SqlScriptExecutor.readSqlScript(FIND_HIGHEST_SALARY_WORKER_QUERY_FILE_PATH);

            try (PreparedStatement statement = connection.prepareStatement(sqlScript);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    HighestSalaryWorker worker = mapResultSetToHighestSalaryWorker(resultSet);
                    result.add(worker);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private HighestSalaryWorker mapResultSetToHighestSalaryWorker(ResultSet resultSet) throws SQLException {
        HighestSalaryWorker highestSalaryWorker = new HighestSalaryWorker();

        highestSalaryWorker.setId(resultSet.getInt("id"));
        highestSalaryWorker.setName(resultSet.getString("name"));
        highestSalaryWorker.setBirthday(resultSet.getDate("birthday"));
        highestSalaryWorker.setLevel(resultSet.getString("level"));
        highestSalaryWorker.setSalary(resultSet.getInt("salary"));

        return highestSalaryWorker;
    }
}