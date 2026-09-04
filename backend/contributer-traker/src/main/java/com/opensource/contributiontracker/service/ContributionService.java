package com.opensource.contributiontracker.service;

import com.opensource.contributiontracker.entity.Contribution;
import com.opensource.contributiontracker.repository.ContributionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContributionService {

    private final ContributionRepository contributionRepository;

    public ContributionService(ContributionRepository contributionRepository) {
        this.contributionRepository = contributionRepository;
    }

    public List<Contribution> getAllContributions() {
        return contributionRepository.findAll();
    }

    public Contribution getContributionById(Long id) {
        return contributionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contribution not found"));
    }

    public Contribution createContribution(Contribution contribution) {
        contribution.setContributionDate(LocalDateTime.now());
        return contributionRepository.save(contribution);
    }

    public void deleteContribution(Long id) {
        contributionRepository.deleteById(id);
    }
}