package com.green.nowon.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //생략 가능
public interface MyUserEntityRepository extends JpaRepository<MyUserEntity, Long> {
	
	//select u(모든 컬럼을 의미) from MyUserEntiyty u where u.email = #{email}; //java에서는 *을 사용하지 못하고 alias 설정 후 입력해야 함
	//Optional은 true, false를 판별함
	Optional<MyUserEntity> findByEmail(String email);

}
