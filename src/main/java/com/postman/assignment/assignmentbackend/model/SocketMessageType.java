package com.postman.assignment.assignmentbackend.model;

public enum SocketMessageType {
    USER_ADD("user_add"),
    USER_REMOVE("user_remove");

    private String messageType;

    SocketMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageType() {
        return messageType;
    }

    public static SocketMessageType getSocketMessageType(String messageType) {
        for (SocketMessageType socketMessageType:SocketMessageType.values()) {
            if (socketMessageType.getMessageType().equals(messageType)) {
                return socketMessageType;
            }
        }
        return null;
    }

}
