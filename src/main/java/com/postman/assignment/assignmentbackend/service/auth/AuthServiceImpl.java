package com.postman.assignment.assignmentbackend.service.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
