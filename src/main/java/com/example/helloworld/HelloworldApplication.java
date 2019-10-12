package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@SpringBootApplication
@ServletComponentScan
public class HelloworldApplication {

    private static Logger logger = LoggerFactory.getLogger(HelloworldApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        String printStr = "\nhello,\nhello,\nhello.\n";
        logger.info(printStr);
        return "hello";
    }
}

