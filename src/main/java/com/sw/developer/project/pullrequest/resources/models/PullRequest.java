
package com.sw.developer.project.pullrequest.resources.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class PullRequest {

    private int id;
    private User user;
    private String state;
    private String title;
    private String body;
    @JsonProperty("created_at")
    private String createdAt;
    private Assignee assignee;
    private int commits;
    private boolean merged;
    private String mergedBy;

}