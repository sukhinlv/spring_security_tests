package com.example.security_tests;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static java.util.Objects.requireNonNull;

public class EmployeeAuthentication implements Authentication {

    private final transient Employee employee;
    private final Collection<? extends GrantedAuthority> authorities;
    private boolean authenticated;

    public EmployeeAuthentication(Employee employee, Collection<? extends GrantedAuthority> authorities) {
        this.employee = requireNonNull(employee);
        this.authorities = requireNonNull(authorities);
        this.authenticated = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return employee;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return employee.getLogin();
    }
}
