package com.sw.developer.project.pullrequest.resources.validators;

import com.sw.developer.project.pullrequest.resources.models.PullRequestEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class ValidatePullRequestEvent {
    private static final String MESSAGE = "Missing Parameters: ";
    private static final String EVENT = "Notification Event";
    private static final String SPACE_DELIMITER = " ";
    private static final String PULL_REQUEST = "Pull Request";

    public Optional<String> validate(PullRequestEvent pullRequestEvent){
        if(Objects.isNull(pullRequestEvent)){
            return createMessage(MESSAGE,EVENT);
        }

        if(Objects.isNull(pullRequestEvent.getPullRequest())){
            return createMessage(MESSAGE,PULL_REQUEST);
        }
        return Optional.empty();
    }
    private Optional<String> createMessage(String... params){
        return Optional.of(String.join(SPACE_DELIMITER, params));
    }
}
