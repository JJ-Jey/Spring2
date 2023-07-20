package com.green.nowon.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyUserServiceProcess implements MyUserService {
	
	private final MyUserEntityRepository repository;
	
	private final PasswordEncoder encoder;

	@Override
	public void saveProcess(MyUserRequestDTO dto) {
		repository.save(dto.toEntity(encoder));
	}

}
