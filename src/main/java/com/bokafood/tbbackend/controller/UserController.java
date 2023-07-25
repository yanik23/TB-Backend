package com.bokafood.tbbackend.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bokafood.tbbackend.entity.User;
import com.bokafood.tbbackend.security.SecurityConstants;
import com.bokafood.tbbackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;


/**
 * Controller class used to handle HTTP requests for the User entity.
 * Its purpose is to refresh the access token of the user.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService userService;

    /**
     * Method to handle HTTP GET requests to refresh the access token of the user.
     * Access token is sent in the Authorization header of the HTTP response.
     *
     * @param request The HTTP request.
     * @param response The HTTP response.
     */
    @GetMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

        // Get the refresh token from the Authorization header of the HTTP request.
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith(SecurityConstants.BEARER)) {
            String tokenStr = header.replace(SecurityConstants.BEARER, "");

            // Verify the refresh token.
            DecodedJWT jwt = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_KEY))
                    .build()
                    .verify(tokenStr);

            // Get the user from the database.
            User user = userService.getUserByUsername(jwt.getSubject());

            // Create a new access token and send it in the Authorization header of the HTTP response.
            String access_token = JWT.create()
                    .withSubject(user.getUsername())
                    .withArrayClaim("roles", new String[]{user.getRole().name()})
                    .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.ACCESS_TOKEN_EXPIRATION))
                    .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));
            response.addHeader(SecurityConstants.AUTHORIZATION, SecurityConstants.BEARER + access_token);
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }
}
