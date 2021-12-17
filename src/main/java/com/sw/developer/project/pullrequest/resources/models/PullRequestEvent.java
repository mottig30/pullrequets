
package com.sw.developer.project.pullrequest.resources.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class PullRequestEvent {

    private String action;
    private String number;
    @JsonProperty("pull_request")
    private PullRequest pullRequest;


}
