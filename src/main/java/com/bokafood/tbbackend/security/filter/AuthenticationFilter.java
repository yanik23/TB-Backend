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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.io.IOException;
import java.util.Date;


/**
 * AuthenticationFilter class used to authenticate a user.
 * Extends the UsernamePasswordAuthenticationFilter class.
 * Filters the request and checks if the user is authenticated.
 * If the user is authenticated, a JWT token is created and added to the response.
 * Autowired did not work here surprisingly, so I used a constructor.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
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

    /**
     * Method to be called if the authentication was not successful.
     * @param request the request that was made.
     * @param response the response to send.
     * @param failed the exception that was thrown.
     * @throws IOException if an input or output exception occurs.
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(failed.getMessage());
        response.getWriter().flush();
    }

    /**
     * Method to be called if the authentication was successful.
     * @param request the request that was made.
     * @param response the response to send.
     * @param chain the filter chain.
     * @param authResult the authentication result.
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {

        String access_token = JWT.create()
                .withSubject(authResult.getName())
                .withArrayClaim("roles", authResult.getAuthorities().stream().map(ga -> ga.getAuthority()).toArray(String[]::new))
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.ACCESS_TOKEN_EXPIRATION))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));
        response.addHeader(SecurityConstants.AUTHORIZATION, SecurityConstants.BEARER + access_token);

        String refresh_token = JWT.create()
                .withSubject(authResult.getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.REFRESH_TOKEN_EXPIRATION))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));
        response.addHeader(SecurityConstants.REFRESH, SecurityConstants.BEARER + refresh_token);
    }
}
