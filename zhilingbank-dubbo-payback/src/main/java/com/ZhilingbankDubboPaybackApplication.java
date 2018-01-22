package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.zhilingbank.dao")
public class ZhilingbankDubboPaybackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhilingbankDubboPaybackApplication.class, args);
	}
}
