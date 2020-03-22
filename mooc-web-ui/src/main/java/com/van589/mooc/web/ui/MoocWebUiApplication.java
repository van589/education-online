package com.van589.mooc.web.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MoocWebUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoocWebUiApplication.class,args);
    }
}
