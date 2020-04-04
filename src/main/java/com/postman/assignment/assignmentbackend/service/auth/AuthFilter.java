package com.postman.assignment.assignmentbackend.service.auth;

import com.postman.assignment.assignmentbackend.constants.Constants;
import com.postman.assignment.assignmentbackend.controller.ActivityController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    private static Logger LOG = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        if (request.getHeader(Constants.AUTHENTICATION_HEADER) == null) {
            return request.getParameter(Constants.AUTHENTICATION_HEADER);
        }
        return request.getHeader(Constants.AUTHENTICATION_HEADER);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }



}
