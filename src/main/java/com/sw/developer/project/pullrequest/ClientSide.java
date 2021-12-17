
package com.sw.developer.project.pullrequest;

import com.sw.developer.project.pullrequest.persistence.services.PullRequestPersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ClientSide {
    @Autowired
    PullRequestPersist pullRequestPersist;

    @RequestMapping ("/clientSide")
    public String notifyPullRequest(Model model){
        model.addAttribute("pullRequests",pullRequestPersist.getAllPullRequests());
        return "pullrequests/pullRequests";
    }

}