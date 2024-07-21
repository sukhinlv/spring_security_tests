package com.example.security_tests;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleControllerImpl implements SampleController {

    @Override
    @PreAuthorize("hasAnyRole({'PERS_MANAGER'})")
    public String testMethod() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Got it! I am an employee: %s".formatted(authentication.getName());
    }

    @Override
    @PreAuthorize("hasAnyRole({'HEAD_SALE_POINT'})")
    public String testSecondMethod() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "testSecondMethod: %s".formatted(authentication.getName());
    }

    @Override
    public String testFreeMethod() {
        return "Free for anybody...";
    }
}
