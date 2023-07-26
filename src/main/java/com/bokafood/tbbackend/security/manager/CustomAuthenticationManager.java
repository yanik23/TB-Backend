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

/**
 * CustomAuthenticationManager class used to authenticate a user.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private UserService userServiceImpl;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     * Method to authenticate a user.
     * @param authentication The authentication object.
     * @return The authentication object if the credientials are correct.
     * @throws AuthenticationException if the authentication failed.
     *
     */
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
