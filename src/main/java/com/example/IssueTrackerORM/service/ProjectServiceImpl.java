package com.example.IssueTrackerORM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IssueTrackerORM.domain.Project;
import com.example.IssueTrackerORM.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        Optional<Project> project = projectRepository.findById((long) id);
        return project.orElse(null);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> searchProjectsByName(String name) {
        return projectRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public long getTotalProjects() {
        return projectRepository.countTotalProjects();
    }

    @Override
    public List<String> getAllProjectNames() {
        return projectRepository.findAllProjectNames();
    }

    @Override
    public List<Project> getProjectsByBugStatus(String status) {
        return projectRepository.findProjectsByBugStatus(status);
    }
}
