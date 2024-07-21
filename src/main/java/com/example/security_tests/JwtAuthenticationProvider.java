package com.example.security_tests;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        return switch (login) {
            case "admin" ->
                    new EmployeeAuthentication(new Employee(login, "Сидоров Прохор Иванович"),
                            List.of(getAuthority("HEAD_SALE_POINT")));
            case "user" ->
                    new EmployeeAuthentication(new Employee(login, "Петров Иван Иваныч"),
                            List.of(getAuthority("PERS_MANAGER")));
            default -> throw new UsernameNotFoundException(login);
        };
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(JwtAuthentication.class);
    }

    private GrantedAuthority getAuthority(String name) {
        return new SimpleGrantedAuthority("ROLE_" + name);
    }
}
