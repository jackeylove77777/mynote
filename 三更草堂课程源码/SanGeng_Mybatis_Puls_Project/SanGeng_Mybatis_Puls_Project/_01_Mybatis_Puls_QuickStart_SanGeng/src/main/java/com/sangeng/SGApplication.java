package com.sangeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan("com.sangeng.mapper")
public class SGApplication {
    public static void main(String[] args) {
        SpringApplication.run(SGApplication.class,args);
    }
}
