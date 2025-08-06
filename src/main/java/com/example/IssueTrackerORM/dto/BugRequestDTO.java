package com.example.IssueTrackerORM.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BugRequestDTO {
    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String status;

    @NotNull
    private Long project;
}
