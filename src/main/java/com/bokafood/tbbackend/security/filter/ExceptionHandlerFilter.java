package com.bokafood.tbbackend.security.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch(EntityNotFoundException ex) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("username or password incorrect");
            response.getWriter().flush();
        } catch (JWTVerificationException ex){
            System.out.println("========== ex.getMessage() : " + ex.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            response.getWriter().write("JWT NOT VALID");
            response.getWriter().flush();
        } catch (RuntimeException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("BAD REQUEST");
            response.getWriter().flush();
        }
    }
}
