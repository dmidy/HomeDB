package org.example.dao;

import org.example.db.Database;
import org.example.model.OldestYoungestWorker;
import org.example.service.SqlScriptExecutor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OldestYoungestWorkerDao {

    private static final String FIND_OLDEST_YOUNGEST_WORKER_QUERY_FILE_PATH =
            "src/main/resources/sql/find_youngest_eldest_workers.sql";

    public List<OldestYoungestWorker> findOldestYoungestWorker() {
        List<OldestYoungestWorker> result = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlScript = SqlScriptExecutor.readSqlScript(FIND_OLDEST_YOUNGEST_WORKER_QUERY_FILE_PATH);

            try (PreparedStatement statement = connection.prepareStatement(sqlScript);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    OldestYoungestWorker worker = mapResultSetToOldestYoungestWorker(resultSet);
                    result.add(worker);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private OldestYoungestWorker mapResultSetToOldestYoungestWorker(ResultSet resultSet) throws SQLException {
        OldestYoungestWorker oldestYoungestWorker = new OldestYoungestWorker();

        oldestYoungestWorker.setType(resultSet.getString("type"));
        oldestYoungestWorker.setName(resultSet.getString("name"));
        oldestYoungestWorker.setBirthday(resultSet.getDate("birthday"));

        return oldestYoungestWorker;
    }
}