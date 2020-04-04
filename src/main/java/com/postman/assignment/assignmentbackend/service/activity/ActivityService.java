package com.postman.assignment.assignmentbackend.service.activity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {
    void addUser(String userName);
    void removeUser(String userName);
    List<String> getUsers();
}
