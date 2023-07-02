package com.bokafood.tbbackend.security;


import com.bokafood.tbbackend.security.filter.AuthenticationFilter;
import com.bokafood.tbbackend.security.filter.JWTAuthorizationFilter;
import com.bokafood.tbbackend.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/login");

        http
            .csrf(csrf -> csrf.disable())
            .authorizeRequests(request -> request
                    .requestMatchers(HttpMethod.GET).permitAll()
                    .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/login").permitAll()
                    .requestMatchers(HttpMethod.POST, "/deliveries").permitAll()
                    .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
                    .anyRequest().authenticated())
            .addFilter(authenticationFilter)
            .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class);
            //.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        return http.build();
    }

}
