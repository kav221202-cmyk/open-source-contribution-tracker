package com.opensource.contributiontracker.controller;

import com.opensource.contributiontracker.entity.Contribution;
import com.opensource.contributiontracker.service.ContributionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributions")
public class ContributionController {

    private final ContributionService contributionService;

    public ContributionController(ContributionService contributionService) {
        this.contributionService = contributionService;
    }

    @GetMapping
    public List<Contribution> getAllContributions() {
        return contributionService.getAllContributions();
    }

    @GetMapping("/{id}")
    public Contribution getContributionById(@PathVariable Long id) {
        return contributionService.getContributionById(id);
    }

    @PostMapping
    public Contribution createContribution(
            @RequestBody Contribution contribution) {

        return contributionService.createContribution(contribution);
    }

    @DeleteMapping("/{id}")
    public void deleteContribution(@PathVariable Long id) {
        contributionService.deleteContribution(id);
    }
}
