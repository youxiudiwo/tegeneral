package com.zuoshao.tegeneral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.zuoshao.tegeneral.mapper")
public class TegeneralApplication {

    public static void main(String[] args) {
        SpringApplication.run(TegeneralApplication.class, args);
    }

}
