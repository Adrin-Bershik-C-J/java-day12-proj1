package com.example.IssueTrackerORM.service;

import java.util.List;
import com.example.IssueTrackerORM.domain.Project;

public interface ProjectService {
    List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project createProject(Project project);

    List<Project> searchProjectsByName(String name);

    long getTotalProjects();

    List<String> getAllProjectNames();

    List<Project> getProjectsByBugStatus(String status);
}
