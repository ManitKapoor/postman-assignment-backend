package com.postman.assignment.assignmentbackend.tests.service.auth;

import com.postman.assignment.assignmentbackend.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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
