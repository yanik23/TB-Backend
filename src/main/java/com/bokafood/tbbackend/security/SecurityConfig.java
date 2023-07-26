package com.bokafood.tbbackend.security;


import com.bokafood.tbbackend.security.filter.AuthenticationFilter;
import com.bokafood.tbbackend.security.filter.ExceptionHandlerFilter;
import com.bokafood.tbbackend.security.filter.JWTAuthorizationFilter;
import com.bokafood.tbbackend.security.manager.CustomAuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


/**
 * SecurityConfig class used to configure the security of the application.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Configuration
public class SecurityConfig {

    @Autowired
    CustomAuthenticationManager customAuthenticationManager;

    /**
     * Method to configure the security of the application.
     * @param http The HttpSecurity object to be configured.
     * @return The configured SecurityFilterChain.
     * @throws Exception If an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/login");
        http
                .authorizeHttpRequests(request -> request
                    //.requestMatchers(HttpMethod.POST).hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/clients").hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.POST).authenticated()
                    .requestMatchers(HttpMethod.PUT, "clients/**").hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.PUT).authenticated()
                    //.requestMatchers(HttpMethod.PUT).authenticated()
                    .requestMatchers(HttpMethod.DELETE, "/deliveries/**").authenticated()
                    .requestMatchers(HttpMethod.DELETE).hasAuthority("ADMIN")
                    .requestMatchers(HttpMethod.GET, "/users/refresh-token").permitAll()
                    .requestMatchers(HttpMethod.GET).authenticated()

                )
                .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
                .addFilter(authenticationFilter)
                .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

}
