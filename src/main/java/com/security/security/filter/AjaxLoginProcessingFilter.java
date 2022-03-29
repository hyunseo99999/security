package com.security.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.domain.Account;
import com.security.security.token.AjaxAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public AjaxLoginProcessingFilter() {
        super(new AntPathRequestMatcher("/api/login"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        if (!isAjax(request)) {
            throw new IllegalStateException("Authentication is not supported");
        }

        Account account = objectMapper.readValue(request.getReader(), Account.class);
        if (StringUtils.isEmpty(account.getUsername()) || StringUtils.isEmpty(account.getPassword())) {
            throw new  IllegalArgumentException("Username or password is empty");
        }
        AjaxAuthenticationToken authenticationToken = new AjaxAuthenticationToken(account.getUsername(), account.getPassword());
        return getAuthenticationManager().authenticate(authenticationToken);
    }

    private boolean isAjax(HttpServletRequest request) {

        if ("XmlHttpRequest".equals(request.getHeader("X-Requested-with"))) {
            return true;
        }

        return false;
    }
}
