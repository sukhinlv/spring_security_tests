package com.example.security_tests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SecurityTestsApplicationTests {

    @Test
    void contextLoads() {
    }

}
