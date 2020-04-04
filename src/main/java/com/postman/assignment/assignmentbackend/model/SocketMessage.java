package com.postman.assignment.assignmentbackend.model;

public class SocketMessage {
    private String messageType;
    private UserData userData;
    public String getMessageType() {
        return messageType;
    }
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    public UserData getUserData() {
        return userData;
    }
    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
