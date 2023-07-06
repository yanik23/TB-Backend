package com.bokafood.tbbackend.security;


import com.bokafood.tbbackend.security.filter.AuthenticationFilter;
import com.bokafood.tbbackend.security.filter.ExceptionHandlerFilter;
import com.bokafood.tbbackend.security.filter.JWTAuthorizationFilter;
import com.bokafood.tbbackend.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import java.sql.SQLOutput;


@Configuration
public class SecurityConfig {

    @Autowired
    CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/login");
        System.out.println("=====================================");
        System.out.println("=========processed til here==========");
        System.out.println("=====================================");
        http
                .authorizeRequests(request -> request
                    .requestMatchers(HttpMethod.GET).authenticated()
                    .requestMatchers(HttpMethod.POST).hasAuthority("ADMIN")
                    //.requestMatchers(HttpMethod.POST).authenticated()
                    .requestMatchers(HttpMethod.PUT).hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.DELETE).hasAuthority("ADMIN")

                )
                .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
                .addFilter(authenticationFilter)
                .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

}
