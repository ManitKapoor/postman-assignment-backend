package com.postman.assignment.assignmentbackend.tests.service.activity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ActivityServiceTest {

    private ActivityService activityService;

    @Test
    void addUser() {
        activityService = new ActivityServiceImpl();
        String addUser = "test";
        activityService.addUser(addUser);
        Assertions.assertEquals(activityService.getUsers().size(),1);
    }

    @Test
    void removeUser() {
        activityService = new ActivityServiceImpl();
        String addUser = "test";
        activityService.addUser(addUser);
        Assertions.assertEquals(activityService.getUsers().size(),1);
        activityService.removeUser(addUser);
        Assertions.assertEquals(activityService.getUsers().size(),0);
    }

}