package com.opensource.contributiontracker.repository;

import com.opensource.contributiontracker.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}