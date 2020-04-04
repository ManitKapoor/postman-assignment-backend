package com.postman.assignment.assignmentbackend.model;

import lombok.Data;

@Data
public class SocketMessage {
    private String messageType;
    private UserData userData;
}
