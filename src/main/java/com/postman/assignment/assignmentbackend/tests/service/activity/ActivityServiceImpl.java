package com.postman.assignment.assignmentbackend.tests.service.activity;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ActivityServiceImpl implements ActivityService {

    private Set<String> userActive;

    public ActivityServiceImpl() {
        userActive = new HashSet<>();
    }

    @Override
    public void addUser(String userName) {
        userActive.add(userName);
    }

    @Override
    public void removeUser(String userName) {
        userActive.remove(userName);
    }

    @Override
    public List<String> getUsers() {
        return new ArrayList<>(userActive);
    }
}
