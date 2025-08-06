package com.example.IssueTrackerORM.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.IssueTrackerORM.domain.Bug;

public interface BugRepository extends JpaRepository<Bug, Long> {

    List<Bug> findByStatus(String status);

    List<Bug> findByProjectId(Long projectId);

    List<Bug> findByAssignedToId(Long userId);

    @Query("SELECT b FROM Bug b WHERE b.assignedTo.id = :userId AND b.status <> 'Resolved'")
    List<Bug> findUnresolvedBugsByUserId(@Param("userId") Long userId);

    @Query("SELECT COUNT(b) FROM Bug b WHERE b.project.id = :projectId")
    long countByProjectId(@Param("projectId") Long projectId);
}
