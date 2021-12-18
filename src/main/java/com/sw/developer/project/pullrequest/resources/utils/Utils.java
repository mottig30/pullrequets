package com.sw.developer.project.pullrequest.resources.utils;

import com.sw.developer.project.pullrequest.resources.models.PullRequestEvent;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class Utils {


    private static final String IMAGE_TYPE_SUFFIX = ".jpg";
    private static final String PROJECT_IMAGE_PATH = "\\src\\main\\resources\\static\\images\\";

    public void getPullRequestScreenShoot(PullRequestEvent pullRequestEvent){
       takeScreenShoot(pullRequestEvent);
    }

    private void takeScreenShoot(PullRequestEvent pullRequestEvent) {
        String pullRequestId = String.valueOf(pullRequestEvent.getPullRequest().getId());
        try{
            Robot bot = new Robot();
            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenShoot = bot.createScreenCapture(rectangle);
            ImageIO.write(screenShoot,"JPG",new File(createImagePath(pullRequestId)));
        }
        catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

    private String createImagePath(String pullRequestId){
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.dir"));
        sb.append(PROJECT_IMAGE_PATH);
        sb.append(pullRequestId);
        sb.append(IMAGE_TYPE_SUFFIX);
        return sb.toString();
    }
}
