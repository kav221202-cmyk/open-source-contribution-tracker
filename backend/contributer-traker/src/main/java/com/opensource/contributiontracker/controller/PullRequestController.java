package com.opensource.contributiontracker.controller;

import com.opensource.contributiontracker.entity.PullRequest;
import com.opensource.contributiontracker.service.PullRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pull-requests")
public class PullRequestController {

    private final PullRequestService pullRequestService;

    public PullRequestController(PullRequestService pullRequestService) {
        this.pullRequestService = pullRequestService;
    }

    @GetMapping
    public List<PullRequest> getAllPullRequests() {
        return pullRequestService.getAllPullRequests();
    }

    @GetMapping("/{id}")
    public PullRequest getPullRequestById(@PathVariable Long id) {
        return pullRequestService.getPullRequestById(id);
    }

    @PostMapping
    public PullRequest createPullRequest(
            @RequestBody PullRequest pullRequest) {

        return pullRequestService.createPullRequest(pullRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePullRequest(@PathVariable Long id) {
        pullRequestService.deletePullRequest(id);
    }
}