package com.freesofts.lowcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableFeignClients("com.freesofts")
@ComponentScan("com.freesofts")
@MapperScan("com.freesofts.lowcode.mapper")
public class LowCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LowCodeApplication.class, args);
    }

}
