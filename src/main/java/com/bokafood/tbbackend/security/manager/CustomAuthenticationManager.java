package com.bokafood.tbbackend.security.manager;


import com.bokafood.tbbackend.entity.User;
import com.bokafood.tbbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private UserService userServiceImpl;
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userServiceImpl.getUserByUsername(authentication.getName());


        if (!authentication.getCredentials().toString().equals(user.getPassword()) ||
            !authentication.getName().equals(user.getUsername())) {
            throw new BadCredentialsException("Wrong username or password");
        }

        System.out.println("user role " + authentication.getAuthorities());
        System.out.println("user role " + user.getAuthorities());
        System.out.println("user role " + user.getRole());
        return new UsernamePasswordAuthenticationToken(authentication.getName(), user.getPassword(), user.getAuthorities());
    }
}
