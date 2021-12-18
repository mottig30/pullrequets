
package com.sw.developer.project.pullrequest.resources.delegate;

import com.sw.developer.project.pullrequest.business.services.NotifyPullRequestApplicationService;
import com.sw.developer.project.pullrequest.exceptions.RequestException;
import com.sw.developer.project.pullrequest.resources.mappers.PullRequestEventToPullRequestDTOMapper;
import com.sw.developer.project.pullrequest.resources.models.PullRequestEvent;
import com.sw.developer.project.pullrequest.resources.utils.Utils;
import com.sw.developer.project.pullrequest.resources.validators.ValidatePullRequestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotifyPullRequestDelegate {

    private static final String REQUEST_PATH = "/pullRequest/notify";

    @Autowired
    PullRequestEventToPullRequestDTOMapper pullRequestEventToPullRequestDTOMapper;

    @Autowired
    NotifyPullRequestApplicationService notifyPullRequestApplicationService;

    @Autowired
    ValidatePullRequestEvent validatePullRequestEvent;

    @Autowired
    Utils utils;

    private static final Logger logger = LoggerFactory.getLogger(NotifyPullRequestDelegate.class);

    @PostMapping(REQUEST_PATH)
    public void notifyPullRequest(@RequestBody PullRequestEvent pullRequestEvent){

        logger.info("New Notification: {}",pullRequestEvent);

        System.setProperty("java.awt.headless", "false");

        validatePullRequestEvent.validate(pullRequestEvent).ifPresent(this::throwBadRequestException);

        utils.getPullRequestScreenShoot(pullRequestEvent);

        notifyPullRequestApplicationService.notifyPullRequest(pullRequestEventToPullRequestDTOMapper.map(pullRequestEvent));
    }
    private void throwBadRequestException (String validationMessage) {
        throw new RequestException(validationMessage);
    }

}