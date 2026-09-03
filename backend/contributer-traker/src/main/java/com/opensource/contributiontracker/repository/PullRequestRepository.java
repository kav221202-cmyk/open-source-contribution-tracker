package com.opensource.contributiontracker.repository;

import com.opensource.contributiontracker.entity.PullRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PullRequestRepository extends JpaRepository<PullRequest, Long> {
}
