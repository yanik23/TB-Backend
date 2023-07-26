package com.bokafood.tbbackend.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bokafood.tbbackend.security.SecurityConstants;
import com.bokafood.tbbackend.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.*;

/**
 * JWTAuthorizationFilter class used to authorize a user.
 * Called once per request after authenticated and after the ExceptionHandlerFilter.
 * Inspired from : https://www.udemy.com/course/the-complete-spring-boot-development-bootcamp/
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        //if the header is null or does not start with the bearer prefix or the request is a refresh token request, we do not filter.
        if(header == null || !header.startsWith(SecurityConstants.BEARER) || request.getServletPath().equals("/users/refresh-token")) {
            filterChain.doFilter(request, response);
        } else {

            String tokenStr = header.replace(SecurityConstants.BEARER, "");

            //verify the token
            DecodedJWT jwt = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_KEY))
                    .build()
                    .verify(tokenStr);

            //get the username and roles from the token
            String user = jwt.getSubject();
            List<String> roles = jwt.getClaim("roles").asList(String.class);


            // Create a collection of GrantedAuthority objects from the roles obtained from the JWT.
            Collection<? extends GrantedAuthority> auths = Collections.singleton(new SimpleGrantedAuthority(roles.get(0)));

            //create an authentication object with the username and the roles
            //It is a token based authentication, so we set the password to null.
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, auths);//to set auth true with this constructor.

            //set the authentication in the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            //call the next filter in the filter chain
            filterChain.doFilter(request, response); //since it is the last filter and we call doFilter, will launch the request.
        }
    }

}
