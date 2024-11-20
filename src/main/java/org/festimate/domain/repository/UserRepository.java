package org.festimate.domain.repository;

import org.festimate.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    // 존재하는 닉네임인지 확인하기
    boolean existsByNickname(String nickname);
}
