
package com.sw.developer.project.pullrequest.business.services;

import com.sw.developer.project.pullrequest.persistence.dto.implementations.PullRequestDTO;
import com.sw.developer.project.pullrequest.persistence.services.PullRequestPersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NotifyPullRequestApplicationService {

    @Autowired
    PullRequestPersist pullRequestPersist;
    public void notifyPullRequest(PullRequestDTO pullRequestDTO){
        pullRequestPersist.persist(pullRequestDTO);

    }
}


