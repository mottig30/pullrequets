
package com.sw.developer.project.pullrequest.persistence.dto.implementations;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tbl_pullrequest_dto")
@Entity
@Setter
@Getter
@ToString
public class PullRequestDTO {

    @Id
    private long id;
    private String state;
    private String user;
    private String requestBody;
    private String title;
    private String body;
    private String createdAt;
    private String assignee;
    private int commits;
    private boolean merged;
}