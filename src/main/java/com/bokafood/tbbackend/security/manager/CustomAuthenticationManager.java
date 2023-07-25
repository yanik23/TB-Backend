package com.bokafood.tbbackend.security.manager;


import com.bokafood.tbbackend.entity.User;
import com.bokafood.tbbackend.service.UserService;
import lombok.AllArgsConstructor;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //private Argon2PasswordEncoder argon2PasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userServiceImpl.getUserByUsername(authentication.getName());

        if (!bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassword()) ||
                !authentication.getName().equals(user.getUsername())) {
            throw new BadCredentialsException("Wrong username or password");
        }

        return new UsernamePasswordAuthenticationToken(authentication.getName(), user.getPassword(), user.getAuthorities());
    }
}
