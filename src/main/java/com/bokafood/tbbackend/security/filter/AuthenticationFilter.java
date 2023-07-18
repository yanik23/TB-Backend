package com.bokafood.tbbackend.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bokafood.tbbackend.entity.User;
import com.bokafood.tbbackend.security.SecurityConstants;
import com.bokafood.tbbackend.security.manager.CustomAuthenticationManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;



@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private CustomAuthenticationManager customAuthenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            return customAuthenticationManager.authenticate(authentication);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(failed.getMessage());
        response.getWriter().flush();
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("WOHHOHOHHOHOH, authentication successful");

        System.out.println("request: " + request);
        System.out.println("response: " + response);
        String access_token = JWT.create()
                .withSubject(authResult.getName())
                .withArrayClaim("roles", authResult.getAuthorities().stream().map(ga -> ga.getAuthority()).toArray(String[]::new))
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.ACCESS_TOKEN_EXPIRATION))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));
        response.addHeader(SecurityConstants.AUTHORIZATION, SecurityConstants.BEARER + access_token);

        String refresh_token = JWT.create()
                .withSubject(authResult.getName())
                //.withArrayClaim("roles", authResult.getAuthorities().stream().map(ga -> ga.getAuthority()).toArray(String[]::new))
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.REFRESH_TOKEN_EXPIRATION))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));
        response.addHeader(SecurityConstants.REFRESH, SecurityConstants.BEARER + refresh_token);
    }
}
