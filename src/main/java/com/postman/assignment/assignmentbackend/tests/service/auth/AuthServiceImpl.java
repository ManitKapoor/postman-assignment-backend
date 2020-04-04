package com.postman.assignment.assignmentbackend.tests.service.auth;

import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private FirebaseAuth firebaseAuth;

    @Override
    public boolean verifyToken(String token) {
        try {
            firebaseAuth.verifyIdToken(token,true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
