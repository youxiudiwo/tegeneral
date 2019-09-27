package com.zuoshao.tegeneral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.zuoshao.tegeneral.mapper")
@EnableSwagger2
public class TegeneralApplication {

    public static void main(String[] args) {
        SpringApplication.run(TegeneralApplication.class, args);
    }

}
