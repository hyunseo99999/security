package com.security.security.common;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

public class FormWebAuthenticationDetails extends WebAuthenticationDetails {

    private String secret_key;

    public FormWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        secret_key = request.getParameter("secret");
    }

    public String getSecret_key() {
        return secret_key;
    }
}
