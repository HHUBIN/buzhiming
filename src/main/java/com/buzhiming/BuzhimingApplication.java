package com.buzhiming;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.buzhiming.mapper")
public class BuzhimingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuzhimingApplication.class, args);
    }

}
