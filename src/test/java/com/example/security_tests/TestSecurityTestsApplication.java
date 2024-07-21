package com.example.security_tests;

import org.springframework.boot.SpringApplication;

public class TestSecurityTestsApplication {

    public static void main(String[] args) {
        SpringApplication.from(SecurityTestsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
