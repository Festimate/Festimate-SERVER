package org.festimate.service;

import org.festimate.api.dto.response.ErrorCode;
import org.festimate.api.dto.response.UserDetailResponse;
import org.festimate.api.exception.CustomException;
import org.festimate.domain.entity.Appearance;
import org.festimate.domain.entity.User;
import org.festimate.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원가입
    public Long signupUser(String username, String nickname, Integer age, String gender, String school, Integer height, String mbti, List<Appearance> appearanceList) {
        // 닉네임 중복 검사
        if (userRepository.existsByNickname(nickname)) {
            throw new CustomException(ErrorCode.INVALID_INPUT_USER_DUPLICATE);
        }

        if(school == null){
            school = "미입력";
        }
        User newUser = new User(username, nickname, age, gender, school, height, mbti, appearanceList);
        return userRepository.save(newUser).getId();
    }

    // 유저 정보 조회 (닉네임, 학교)
    public UserDetailResponse getUserDetailById(Long userId) {
        // 유저 존재 여부 확인
        User user = findByIdOrThrow(userId);
        return new UserDetailResponse(user.getNickname(), user.getSchool());
    }

    // 닉네임으로 유저 조회
    public User findByIdOrThrow(final Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );
    }
}
