package com.opensource.contributiontracker.service;

import com.opensource.contributiontracker.entity.PullRequest;
import com.opensource.contributiontracker.repository.PullRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PullRequestService {

    private final PullRequestRepository pullRequestRepository;

    public PullRequestService(PullRequestRepository pullRequestRepository) {
        this.pullRequestRepository = pullRequestRepository;
    }

    public List<PullRequest> getAllPullRequests() {
        return pullRequestRepository.findAll();
    }

    public PullRequest getPullRequestById(Long id) {
        return pullRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pull request not found"));
    }

    public PullRequest createPullRequest(PullRequest pullRequest) {
        pullRequest.setCreatedAt(LocalDateTime.now());
        return pullRequestRepository.save(pullRequest);
    }

    public void deletePullRequest(Long id) {
        pullRequestRepository.deleteById(id);
    }
}