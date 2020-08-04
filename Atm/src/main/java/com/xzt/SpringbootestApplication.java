package com.xzt;

import org.apache.ibatis.annotations.Options;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.xzt.dao")
@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
public class SpringbootestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootestApplication.class, args);
	}

}
