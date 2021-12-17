
package com.sw.developer.project.pullrequest.resources.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User {
    @JsonProperty("login")
    private String userName;


}