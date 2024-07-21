package com.example.security_tests;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

public interface SampleController {

    @GetMapping(value = "/V1/test", produces = MediaType.APPLICATION_JSON_VALUE)
    String testMethod();

    @GetMapping(value = "/V1/test-second", produces = MediaType.APPLICATION_JSON_VALUE)
    String testSecondMethod();

    @GetMapping(value = "/V2/test-free", produces = MediaType.APPLICATION_JSON_VALUE)
    String testFreeMethod();
}
