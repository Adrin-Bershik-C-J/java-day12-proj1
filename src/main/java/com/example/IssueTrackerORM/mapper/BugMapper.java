package com.example.IssueTrackerORM.mapper;

import com.example.IssueTrackerORM.domain.Bug;
import com.example.IssueTrackerORM.domain.Project;
import com.example.IssueTrackerORM.dto.BugRequestDTO;
import com.example.IssueTrackerORM.dto.BugResponseDTO;

public class BugMapper {
    
    public static Bug dtoToEntity(BugRequestDTO dto, Project project) {
        Bug bug = new Bug();
        bug.setName(dto.getName());
        bug.setDescription(dto.getDescription());
        bug.setStatus(dto.getStatus());
        bug.setProject(project);
        return bug;
    }

    public static BugResponseDTO EntityToDto(Bug bug) {
        BugResponseDTO bugResponseDTO = new BugResponseDTO();
        bugResponseDTO.setId(bug.getId());
        bugResponseDTO.setName(bug.getName());
        bugResponseDTO.setStatus(bug.getStatus());
        bugResponseDTO.setDescription(bug.getDescription());
        bugResponseDTO.setProjectName(bug.getProject().getName());
        return bugResponseDTO;
    }
}
