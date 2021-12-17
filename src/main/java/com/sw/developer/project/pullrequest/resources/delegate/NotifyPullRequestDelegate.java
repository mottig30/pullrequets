
package com.sw.developer.project.pullrequest.resources.delegate;

import com.sw.developer.project.pullrequest.business.services.NotifyPullRequestApplicationService;
import com.sw.developer.project.pullrequest.exceptions.RequestException;
import com.sw.developer.project.pullrequest.resources.mappers.PullRequestEventToPullRequestDTOMapper;
import com.sw.developer.project.pullrequest.resources.models.PullRequestEvent;
import com.sw.developer.project.pullrequest.resources.validators.ValidatePullRequestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotifyPullRequestDelegate {

    @Autowired
    PullRequestEventToPullRequestDTOMapper pullRequestEventToPullRequestDTOMapper;

    @Autowired
    NotifyPullRequestApplicationService notifyPullRequestApplicationService;

    @Autowired
    ValidatePullRequestEvent validatePullRequestEvent;

    @PostMapping("/pullRequest/notify")
    public void notifyPullRequest(@RequestBody PullRequestEvent pullRequestEvent){
        validatePullRequestEvent.validate(pullRequestEvent).ifPresent(this::throwBadRequestException);
        notifyPullRequestApplicationService.notifyPullRequest(pullRequestEventToPullRequestDTOMapper.map(pullRequestEvent));

    }

    private void throwBadRequestException (String validationMessage) {
        throw new RequestException(validationMessage);
    }

}