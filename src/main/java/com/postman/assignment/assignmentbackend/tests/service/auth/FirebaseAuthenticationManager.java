package com.postman.assignment.assignmentbackend.tests.service.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class FirebaseAuthenticationManager implements AuthenticationManager {

    private static Logger LOG = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    private AuthService authService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getPrincipal();
        authentication.setAuthenticated(authService.verifyToken(token));
        return authentication;
    }
}
