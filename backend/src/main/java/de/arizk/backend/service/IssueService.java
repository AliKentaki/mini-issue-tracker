package de.arizk.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.arizk.backend.model.Issue;
import de.arizk.backend.repository.IssueRepository;


@Service
public class IssueService {
    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository){
        this.issueRepository = issueRepository;
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Optional<Issue> getIssueById(Long id){
        return issueRepository.findById(id);
    }

    public Issue saveIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public void deleteIssue(Long id){
        issueRepository.deleteById(id);
    }
}
