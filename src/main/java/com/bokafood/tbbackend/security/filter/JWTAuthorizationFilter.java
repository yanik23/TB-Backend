package com.bokafood.tbbackend.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bokafood.tbbackend.entity.User;
import com.bokafood.tbbackend.repository.UserRepository;
import com.bokafood.tbbackend.security.SecurityConstants;
import com.bokafood.tbbackend.service.UserService;
import com.bokafood.tbbackend.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.*;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {


    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if(header == null || !header.startsWith(SecurityConstants.BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }


        String tokenStr = header.replace(SecurityConstants.BEARER, "");

        DecodedJWT jwt = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_KEY))
                .build()
                .verify(tokenStr);

        String user = jwt.getSubject();
        List<String> roles = jwt.getClaim("roles").asList(String.class);


        System.out.println("===USER : " + user);


        /*if(authorities != null && !authorities.isEmpty()) {
            String[] roles = authorities.split(",");
            for(String role : roles) {
                grantedAuthorities.add((GrantedAuthority) () -> role);
            }
        }*/


        Collection<? extends GrantedAuthority> auths = Collections.singleton(new SimpleGrantedAuthority(roles.get(0)));
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, auths);//to set auth true with this constructor.
        System.out.println("===AUTHENTICATION : " + authentication.getAuthorities().toString());
        System.out.println("===AUTHENTICATION : " + authentication.getPrincipal());
        System.out.println("===AUTHENTICATION : " + authentication.getCredentials());


        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response); //since it is the last filter and we call doFilter, will launch the request.
    }

    /*public Collection<? extends GrantedAuthority> getAuthorities(String) {
        return Collections.singleton(new SimpleGrantedAuthority(role.name()));
    }*/

}
