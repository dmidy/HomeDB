package org.example.model;

public class TopClientProjects {
    private String name;
    private int projectCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "TopClientProjects{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
