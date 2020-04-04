package com.postman.assignment.assignmentbackend.tests.service.activity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {
    void addUser(String userName);
    void removeUser(String userName);
    List<String> getUsers();
}
