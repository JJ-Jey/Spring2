package com.green.nowon.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Setter;

//@Getter //노출이 될 위험이 있어서 사용하지 않음
@Setter
public class MyUserRequestDTO { //회원가입을 위한 DTO
	
	private String email;
	private String password;
	
	//꼭 여기서 만들지 않고 serviceProcess에서 만들어도 됨 >> 가져오기 위해서 Getter가 필요함
	public MyUserEntity toEntity(PasswordEncoder encoder) {
		return MyUserEntity.builder()
				.email(email)
				.password(encoder.encode(password))
				.build();
	}

}
