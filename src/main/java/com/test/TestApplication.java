package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class


TestApplication {

    public static void main(String[] args) {
        //SSLUtil.setDefaultTrustStore();
        SpringApplication.run(TestApplication.class, args);
    }
}
