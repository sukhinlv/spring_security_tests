package com.example.security_tests;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (nonNull(authHeader) && authHeader.startsWith("Bearer ")) {
                String token = authHeader.split(" ")[1].trim();
                JwtAuthentication authentication = new JwtAuthentication(token);

                Authentication authenticated = authenticationManager.authenticate(authentication);

                SecurityContext ctx = SecurityContextHolder.createEmptyContext();
                ctx.setAuthentication(authenticated);
                SecurityContextHolder.setContext(ctx);
            }
        } finally {
            filterChain.doFilter(request, response);
        }
    }
}
