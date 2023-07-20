package com.green.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class MyWebSecurityConfig {
	
	//옛날 버전 예시
	/*
	@Bean //Bean 객체이므로 public 굳이 사용하지 않아도 됨
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeRequests()
					.requestMatchers("/").permitAll()
					.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
				.and()
				.csrf().disable()
				.build();
	}
	*/
	
	@Bean //Bean 객체이므로 public 굳이 사용하지 않아도 됨
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/", "/signup", "/user").permitAll() //antMatchers가 requestMatchers로 바뀜
						.anyRequest().authenticated()
						)
				//인증이 필요할 때 security 로그인 페이지(사용자 페이지로 이동시 설정)로 이동
				.formLogin(form -> form
						.loginPage("/login") //get요청
						.loginProcessingUrl("/login") //post요청
						.usernameParameter("email") //default: username >> html form 태그의 name
						.passwordParameter("password") //default: password >> 같으면 생략 가능
						.defaultSuccessUrl("/", true)
						.permitAll()
						)
				//로그아웃 사용자 정의시 설정
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/")
						)
				.csrf(csrf -> csrf.disable()) //csrf가 적용되어있으면 post로 보내야함
				.build();
	}
	
	//여기에 만들면 순환구조에 빠져 오류가 생길 가능성이 있어서 SpringSecurity6Config04Application에 만들기
	/*
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(13); //default: 10
	}
	*/

}
