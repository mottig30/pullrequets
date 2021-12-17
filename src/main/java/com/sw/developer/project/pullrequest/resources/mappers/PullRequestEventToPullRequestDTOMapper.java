
package com.sw.developer.project.pullrequest.resources.mappers;

import com.sw.developer.project.pullrequest.persistence.dto.implementations.PullRequestDTO;
import com.sw.developer.project.pullrequest.resources.models.PullRequest;
import com.sw.developer.project.pullrequest.resources.models.PullRequestEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PullRequestEventToPullRequestDTOMapper {
    public PullRequestDTO map(PullRequestEvent pullRequestEvent){
        PullRequestDTO pullRequestDTO = new PullRequestDTO();
        PullRequest pullRequest = pullRequestEvent.getPullRequest();
        pullRequestDTO.setId(pullRequest.getId());
        pullRequestDTO.setState(pullRequest.getState());
        pullRequestDTO.setRequestBody(pullRequest.getBody());
        if(Objects.nonNull(pullRequest.getAssignee())) {
            pullRequestDTO.setAssignee(pullRequest.getAssignee().getLogin());
        }
        if(Objects.nonNull(pullRequest.getUser())) {
            pullRequestDTO.setUser(pullRequest.getUser().getUserName());
        }
        pullRequestDTO.setTitle(pullRequest.getTitle());
        pullRequestDTO.setBody(pullRequest.getBody());
        pullRequestDTO.setCommits(pullRequestDTO.getCommits());
        pullRequestDTO.setCreatedAt(pullRequest.getCreatedAt());
        return pullRequestDTO;
    }
}