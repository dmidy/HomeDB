package org.example.service;

import org.example.model.*;
import org.example.dao.*;

import java.util.List;

public class DatabaseQueryService {

    private final HighestSalaryWorkerDao highestSalaryWorkerDao;
    private final MaxDurationProjectDao maxDurationProjectDao;
    private final OldestYoungestWorkerDao oldestYoungestWorkerDao;
    private final ProjectCostDao projectCostDao;
    private final TopClientProjectsDao topClientProjectsDao;

    public DatabaseQueryService() {
        this.highestSalaryWorkerDao = new HighestSalaryWorkerDao();
        this.maxDurationProjectDao = new MaxDurationProjectDao();
        this.oldestYoungestWorkerDao = new OldestYoungestWorkerDao();
        this.projectCostDao = new ProjectCostDao();
        this.topClientProjectsDao = new TopClientProjectsDao();
    }

    public List<HighestSalaryWorker> findHighestSalaryWorker() {
        return highestSalaryWorkerDao.findHighestSalaryWorker();
    }

    public List<MaxDurationProject> findMaxDurationProject() {
        return maxDurationProjectDao.findMaxDurationProject();
    }

    public List<OldestYoungestWorker> findOldestYoungestWorker() {
        return oldestYoungestWorkerDao.findOldestYoungestWorker();
    }

    public List<ProjectCost> findProjectCost() {
        return projectCostDao.findProjectCost();
    }

    public List<TopClientProjects> findTopClientProjects() {
        return topClientProjectsDao.findTopClientProjects();
    }
}