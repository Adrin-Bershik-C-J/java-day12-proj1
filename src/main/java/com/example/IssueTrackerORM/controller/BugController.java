package com.example.IssueTrackerORM.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.IssueTrackerORM.domain.Bug;
import com.example.IssueTrackerORM.dto.BugRequestDTO;
import com.example.IssueTrackerORM.dto.BugResponseDTO;
import com.example.IssueTrackerORM.service.BugService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bugs")
public class BugController {

    @Autowired
    private BugService bugService;

    @GetMapping
    public List<Bug> getAllBugs() {
        return bugService.getAllBugs();
    }

    @GetMapping("/status/{status}")
    public List<Bug> getBugsByStatus(@PathVariable String status) {
        return bugService.findByStatus(status);
    }

    @GetMapping("/project/{projectId}")
    public List<Bug> getBugsByProjectId(@PathVariable Long projectId) {
        return bugService.findByProjectId(projectId);
    }

    @GetMapping("/assigned/{userId}")
    public List<Bug> getBugsByAssignedTo(@PathVariable Long userId) {
        return bugService.findByAssignedToId(userId);
    }

    @PostMapping
    public ResponseEntity<BugResponseDTO> createBug(@RequestBody @Valid BugRequestDTO bugRequestDTO) {
        BugResponseDTO createdBug = bugService.createBugFromDTO(bugRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBug);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BugResponseDTO> updateBug(@PathVariable Long id,
            @RequestBody @Valid BugRequestDTO bugRequestDTO) {
        return bugService.updateBugFromDTO(id, bugRequestDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bug> getBugById(@PathVariable Long id) {
        return bugService.getBugById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBug(@PathVariable Long id) {
        if (bugService.deleteBug(id)) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Bug with ID " + id + " was deleted successfully.");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Bug with ID " + id + " not found."));
        }
    }

}
