package de.arizk.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.arizk.backend.model.Issue;
import de.arizk.backend.service.IssueService;

@RestController
@RequestMapping("/api/issues")
public class IssueController {
    
    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping
    public List<Issue> getAllIssues(){
        return issueService.getAllIssues();
    }

    @GetMapping("/{id}")
    public Optional<Issue> getIssueById(@PathVariable Long id){
        return issueService.getIssueById(id);
    }

    @PostMapping
    public Issue createIssue(@RequestBody Issue issue){
        return issueService.saveIssue(issue);
    }
    
    public void deleteIssue(@PathVariable Long id){
        issueService.deleteIssue(id);
    }
}

