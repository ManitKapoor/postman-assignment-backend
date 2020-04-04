package com.postman.assignment.assignmentbackend.controller;

import com.postman.assignment.assignmentbackend.tests.service.activity.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestActivityController {

    private ActivityService activityService;

    private static Logger LOG = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    public RestActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/users")
    public List<String> getUsers() {
        LOG.info("Get Method for users is called");
        return activityService.getUsers();
    }

}
