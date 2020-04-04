package com.postman.assignment.assignmentbackend.tests.service.auth;

import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

class AuthServiceTest {

    private AuthService authService;

    @Test
    void verifyToken( ) {
        authService = PowerMockito.mock(AuthService.class);
        String token = null;
        when(authService.verifyToken(null)).thenReturn(false);
        Assert.isTrue(!authService.verifyToken(token),"Verification fail case");
    }
}