
package com.sw.developer.project.pullrequest.persistence.services;

import com.sw.developer.project.pullrequest.business.repository.interfaces.IPullRequestRepository;
import com.sw.developer.project.pullrequest.persistence.dto.implementations.PullRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PullRequestPersist {

    @Autowired
    IPullRequestRepository pullRequestRepository;

    public void persist(PullRequestDTO pullRequestDTO){
        pullRequestRepository.save(pullRequestDTO);
    }

    public List<PullRequestDTO> getAllPullRequests(){
        return pullRequestRepository.findAll();
    }

    public long count(){
        return pullRequestRepository.count();
    }

}