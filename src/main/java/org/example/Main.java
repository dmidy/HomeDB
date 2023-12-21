package org.example;

import org.example.dao.*;
import org.example.model.*;
import org.example.service.DatabaseQueryService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        List<HighestSalaryWorker> highestSalaryWorkers = databaseQueryService.findHighestSalaryWorker();
        List<MaxDurationProject> maxDurationProjects = databaseQueryService.findMaxDurationProject();
        List<OldestYoungestWorker> oldestYoungestWorkers = databaseQueryService.findOldestYoungestWorker();
        List<ProjectCost> projectCosts = databaseQueryService.findProjectCost();
        List<TopClientProjects> topClientProjects = databaseQueryService.findTopClientProjects();

        System.out.println("Highest Salary Workers:");
        for (HighestSalaryWorker worker : highestSalaryWorkers) {
            System.out.println(worker);
        }

        System.out.println("\nMax Duration Projects:");
        for (MaxDurationProject project : maxDurationProjects) {
            System.out.println(project);
        }

        System.out.println("\nOldest and Youngest Workers:");
        for (OldestYoungestWorker worker : oldestYoungestWorkers) {
            System.out.println(worker);
        }

        System.out.println("\nProject Costs:");
        for (ProjectCost projectCost : projectCosts) {
            System.out.println(projectCost);
        }

        System.out.println("\nTop Client Projects:");
        for (TopClientProjects clientProjects : topClientProjects) {
            System.out.println(clientProjects);
        }
    }
}