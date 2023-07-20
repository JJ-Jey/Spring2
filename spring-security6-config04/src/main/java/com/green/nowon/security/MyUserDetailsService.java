package com.green.nowon.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component //서비스로 등록해도 상관없음: bean으로 등록하기 위한 목적
public class MyUserDetailsService implements UserDetailsService {
	
	private final MyUserEntityRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("등록되지 않은 이메일입니다.")); //functional interface: supplier(파라미터 X, 리턴 O)
	}

}
