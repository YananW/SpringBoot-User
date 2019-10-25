package com.mly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mly.mapper")
public class SpringbootUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootUserApplication.class, args);
    }

}
