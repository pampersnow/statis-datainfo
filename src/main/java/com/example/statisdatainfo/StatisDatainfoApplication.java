package com.example.statisdatainfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.statisdatainfo.dao")
public class StatisDatainfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatisDatainfoApplication.class, args);
	}

}

