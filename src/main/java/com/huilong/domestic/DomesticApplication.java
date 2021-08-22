package com.huilong.domestic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.huilong.domestic.dao"})
public class DomesticApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomesticApplication.class, args);
    }

}
