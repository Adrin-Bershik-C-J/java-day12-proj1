package com.example.IssueTrackerORM.dto;

import lombok.Data;

@Data
public class BugResponseDTO {

    private Long id;
    private String name;
    private String status;
    private String description;
    private String projectName;
    
}
