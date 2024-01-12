package org.example.service;


import lombok.SneakyThrows;
import org.example.service.models.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class DatabasePopulateService {
    @SneakyThrows
    public static void main(String[] args) throws SQLException {

        PreparedStatement clientStatement = null;
        PreparedStatement workerStatement = null;
        PreparedStatement projectStatement = null;
        PreparedStatement projectWorkerStatement = null;

        DatabaseInitUtility databaseInitUtility = new DatabaseInitUtility();
        List<Client> clients = Arrays.asList(
                new Client(1, "SupSap"),
                new Client(2, "Bim-Bom"),
                new Client(3, "Garden"),
                new Client(4, "GreenOver"),
                new Client(5, "Krupsi")
        );
        List<Worker> workers = Arrays.asList(
                new Worker(1, "Bob Strange", "1990-02-01", "Junior", 800),
                new Worker(2, "Kim Korty", "1985-05-15", "Senior", 3000),
                new Worker(3, "Stan Frozen", "1983-06-11", "Senior", 3100),
                new Worker(4, "Alfred Montery", "1994-09-21", "Senior", 2900),
                new Worker(5, "Bill Spaw", "1981-02-28", "Middle", 1200),
                new Worker(6, "Gregor McBoo", "1985-03-10", "Middle", 1500),
                new Worker(7, "Suren Vasardyan", "1991-11-03", "Junior", 900),
                new Worker(8, "Li Mo", "1995-07-19", "Trainee", 700),
                new Worker(9, "Dunkan Bread", "1989-07-17", "Junior", 850),
                new Worker(10, "Amirah Al-Farsi", "1992-09-11", "Trainee", 650)
        );
        List<Project> projects = Arrays.asList(
                new Project(1, 1, "2023-01-01", "2023-12-30"),
                new Project(2, 2, "2023-02-01", "2023-11-30"),
                new Project(3, 3, "2023-01-01", "2023-10-31"),
                new Project(4, 4, "2023-03-01", "2023-11-30"),
                new Project(5, 5, "2023-02-01", "2023-09-30"),
                new Project(6, 2, "2023-04-01", "2023-11-30"),
                new Project(7, 1, "2023-06-01", "2023-09-30"),
                new Project(8, 5, "2023-03-01", "2023-11-30"),
                new Project(9, 3, "2023-06-01", "2023-11-30"),
                new Project(10, 4, "2023-05-01", "2023-10-31")
        );
        List<ProjectWorker> projectWorkers = Arrays.asList(
                new ProjectWorker(1, 1),
                new ProjectWorker(2, 3),
                new ProjectWorker(3, 4),
                new ProjectWorker(4, 5),
                new ProjectWorker(5, 6),
                new ProjectWorker(6, 2),
                new ProjectWorker(7, 3),
                new ProjectWorker(8, 2),
                new ProjectWorker(9, 3),
                new ProjectWorker(10, 5),
                new ProjectWorker(1, 2),
                new ProjectWorker(2, 7),
                new ProjectWorker(3, 4),
                new ProjectWorker(4, 1),
                new ProjectWorker(5, 5),
                new ProjectWorker(6, 8),
                new ProjectWorker(7, 10),
                new ProjectWorker(1, 10),
                new ProjectWorker(2, 8),
                new ProjectWorker(3, 7),
                new ProjectWorker(4, 7),
                new ProjectWorker(5, 9)
        );
        clientStatement = databaseInitUtility.initStatementClient();
        workerStatement = databaseInitUtility.initStatementWorker();
        projectStatement = databaseInitUtility.initStatementProject();
        projectWorkerStatement = databaseInitUtility.initStatementProjectWorker();

        for (Client client : clients) {
            addBatchForClientData(client, clientStatement);
        }
        clientStatement.executeBatch();
        clientStatement.clearBatch();

        for (Worker worker : workers) {
            addBatchForWorkerData(worker, workerStatement);
        }
        workerStatement.executeBatch();
        workerStatement.clearBatch();

        for (Project project : projects) {
            addBatchForProjectData(project, projectStatement);
        }
        projectStatement.executeBatch();
        projectStatement.clearBatch();

        for (ProjectWorker projectWorker : projectWorkers) {
            addBatchForProjectWorkerData(projectWorker, projectWorkerStatement);
        }
        projectWorkerStatement.executeBatch();
        projectWorkerStatement.clearBatch();
    }

    public static void addBatchForClientData(Client client, PreparedStatement clientStatement) {
        try {
            clientStatement.setInt(1, client.getId());
            clientStatement.setString(2, client.getName());
            clientStatement.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBatchForWorkerData(Worker worker, PreparedStatement workerStatement) {
        try {
            workerStatement.setInt(1, worker.getId());
            workerStatement.setString(2, worker.getName());
            workerStatement.setString(3, worker.getBirthday());
            workerStatement.setString(4, worker.getLevel());
            workerStatement.setInt(5, worker.getSalary());
            workerStatement.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void addBatchForProjectData(Project project, PreparedStatement projectStatement) {
        try {
            projectStatement.setInt(1, project.getId());
            projectStatement.setInt(2, project.getClientId());
            projectStatement.setString(3, project.getStartDate());
            projectStatement.setString(4, project.getFinishData());
            projectStatement.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBatchForProjectWorkerData(ProjectWorker projectWorker, PreparedStatement projectWorkerStatement) {
        try {
            projectWorkerStatement.setInt(1, projectWorker.getProjectId());
            projectWorkerStatement.setInt(2, projectWorker.getWorkerId());
            projectWorkerStatement.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
