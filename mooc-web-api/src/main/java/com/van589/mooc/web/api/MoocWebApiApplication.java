package com.van589.mooc.web.api;

import com.van589.mooc.web.api.dao.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.van589.mooc.web.api.dao")
@EnableTransactionManagement
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MoocWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoocWebApiApplication.class, args);
    }

}
