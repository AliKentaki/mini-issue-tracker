package de.arizk.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    
    @PutMapping("/{id}")
    public Issue updateIssue(@PathVariable Long id, @RequestBody Issue issue) {
        Issue existingIssue = getIssueById(id).orElse(null);
        if(existingIssue == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Issue nicht gefunden");
        }

        if(issue.getTitle() != null) {
            existingIssue.setTitle(issue.getTitle());
        }

        if (issue.getDescription() != null) {
            existingIssue.setDescription(issue.getDescription());
        }

        if(issue.getStatus() != null) {
            existingIssue.setStatus(issue.getStatus());
        }
        
        return issueService.saveIssue(existingIssue);
        
    }


    @DeleteMapping("/{id}")
    public void deleteIssue(@PathVariable Long id){
        issueService.deleteIssue(id);
    }
}

