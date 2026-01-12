package com.policene.prova_dixi_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProvaDixiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvaDixiApiApplication.class, args);
    }

}
