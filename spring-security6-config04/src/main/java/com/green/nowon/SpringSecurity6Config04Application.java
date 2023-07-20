package com.green.nowon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurity6Config04Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity6Config04Application.class, args);
	}
	
	//MyWebSecurityConfig에 만들면 순환구조에 빠져 오류가 생길 가능성이 있어서 여기(MainApplication)에 만들기
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(13); //default: 10
	}

}
