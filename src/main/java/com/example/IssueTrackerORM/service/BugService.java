package com.example.IssueTrackerORM.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.IssueTrackerORM.domain.Bug;
import com.example.IssueTrackerORM.domain.Project;
import com.example.IssueTrackerORM.dto.BugRequestDTO;
import com.example.IssueTrackerORM.dto.BugResponseDTO;
import com.example.IssueTrackerORM.exceptions.ResourceNotFoundException;
import com.example.IssueTrackerORM.mapper.BugMapper;
import com.example.IssueTrackerORM.repository.BugRepository;
import com.example.IssueTrackerORM.repository.ProjectRepository;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }

    public List<Bug> findByStatus(String status) {
        return bugRepository.findByStatus(status);
    }

    public List<Bug> findByProjectId(Long projectId) {
        return bugRepository.findByProjectId(projectId);
    }

    public List<Bug> findByAssignedToId(Long userId) {
        return bugRepository.findByAssignedToId(userId);
    }

    public BugResponseDTO createBugFromDTO(BugRequestDTO dto) {
        Project project = projectRepository.findById(dto.getProject())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + dto.getProject()));

        Bug bug = BugMapper.dtoToEntity(dto, project);
        bug.setStatus(dto.getStatus()); // Ensure status is set
        Bug saved = bugRepository.save(bug);

        return BugMapper.EntityToDto(saved);
    }

    public Optional<Bug> getBugById(Long id) {
        return bugRepository.findById(id);
    }

    public Optional<BugResponseDTO> updateBugFromDTO(Long id, BugRequestDTO dto) {
        return bugRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setDescription(dto.getDescription());
            existing.setStatus(dto.getStatus());
            Bug updated = bugRepository.save(existing);
            return BugMapper.EntityToDto(updated);
        });
    }

    public boolean deleteBug(Long id) {
        if (bugRepository.existsById(id)) {
            bugRepository.deleteById(id);
            return true;
        }
        return false;
    }
}