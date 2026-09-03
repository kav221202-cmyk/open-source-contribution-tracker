package com.opensource.contributiontracker.service;

import com.opensource.contributiontracker.entity.Issue;
import com.opensource.contributiontracker.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Issue getIssueById(Long id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found"));
    }

    public Issue createIssue(Issue issue) {
        issue.setCreatedAt(LocalDateTime.now());
        return issueRepository.save(issue);
    }

    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }
}