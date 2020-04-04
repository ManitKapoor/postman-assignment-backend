package com.postman.assignment.assignmentbackend.service.auth;

import org.springframework.stereotype.Service;

@Service
public interface AuthService{
    boolean verifyToken(String token);
}
