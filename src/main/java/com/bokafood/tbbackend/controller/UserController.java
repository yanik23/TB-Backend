package com.bokafood.tbbackend.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bokafood.tbbackend.dto.users.UserDTO;
import com.bokafood.tbbackend.entity.User;
import com.bokafood.tbbackend.security.SecurityConstants;
import com.bokafood.tbbackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/users")
public class UserController {

    /*@Autowired
    private UserService userService;


    @GetMapping("/login")
    public ResponseEntity<UserDTO> login() {
        return new ResponseEntity<>(userService., HttpStatus.OK);
    }*/

    @Autowired
    UserService userService;

    @GetMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith(SecurityConstants.BEARER)) {
            String tokenStr = header.replace(SecurityConstants.BEARER, "");

            DecodedJWT jwt = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_KEY))
                    .build()
                    .verify(tokenStr);

            //============
            User user = userService.getUserByUsername(jwt.getSubject());

            String access_token = JWT.create()
                    .withSubject(user.getUsername())
                    .withArrayClaim("roles", new String[]{user.getRole().name()})
                    .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.ACCESS_TOKEN_EXPIRATION))
                    .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));
            response.addHeader(SecurityConstants.AUTHORIZATION, SecurityConstants.BEARER + access_token);
            //=============

            String username = jwt.getSubject();
            List<String> roles = jwt.getClaim("roles").asList(String.class);

            //System.out.println("===USER : " + user);

            //Collection<? extends GrantedAuthority> auths = Collections.singleton(new SimpleGrantedAuthority(roles.get(0)));
        /*System.out.println("===AUTHENTICATION : " + authentication.getAuthorities().toString());
        System.out.println("===AUTHENTICATION : " + authentication.getPrincipal());
        System.out.println("===AUTHENTICATION : " + authentication.getCredentials());*/
            //SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            //return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            throw new RuntimeException("Refresh token is missing");
        }
    }
}
