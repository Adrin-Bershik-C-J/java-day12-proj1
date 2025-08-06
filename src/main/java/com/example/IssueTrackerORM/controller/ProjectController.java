package com.example.IssueTrackerORM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.IssueTrackerORM.domain.Project;
import com.example.IssueTrackerORM.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return (project != null) ? ResponseEntity.ok(project) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @GetMapping("/search/{name}")
    public List<Project> searchProjects(@PathVariable String name) {
        return projectService.searchProjectsByName(name);
    }

    @GetMapping("/count")
    public long getTotalProjects() {
        return projectService.getTotalProjects();
    }

    @GetMapping("/names")
    public List<String> getProjectNames() {
        return projectService.getAllProjectNames();
    }

    @GetMapping("/bug-status/{status}")
    public List<Project> getProjectsByBugStatus(@PathVariable String status) {
        return projectService.getProjectsByBugStatus(status);
    }
}
