package com.opensource.contributiontracker.repository;

import com.opensource.contributiontracker.entity.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributionRepository extends JpaRepository<Contribution, Long> {
}