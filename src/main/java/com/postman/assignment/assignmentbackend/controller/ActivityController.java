package com.postman.assignment.assignmentbackend.controller;

import com.postman.assignment.assignmentbackend.model.SocketMessage;
import com.postman.assignment.assignmentbackend.model.SocketMessageType;
import com.postman.assignment.assignmentbackend.tests.service.activity.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ActivityController {

    private ActivityService activityService;

    private static Logger LOG = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @MessageMapping("/activity")
    @SendTo("/topic/activity")
    public List<String> message(SocketMessage message) throws Exception {
        LOG.info("Socket Message arrived");
        SocketMessageType socketMessageType = SocketMessageType.getSocketMessageType(message.getMessageType());
        if (socketMessageType != null) {
            if (socketMessageType == SocketMessageType.USER_ADD) {
                activityService.addUser(message.getUserData().getName());
            }
            if (socketMessageType == SocketMessageType.USER_REMOVE) {
                activityService.removeUser(message.getUserData().getName());
            }
        } else {
            LOG.error("socket message is null " + message.getMessageType());
        }
        return activityService.getUsers();
    }
}