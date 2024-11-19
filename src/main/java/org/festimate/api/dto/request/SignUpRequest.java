package org.festimate.api.dto.request;

import jakarta.validation.constraints.*;
import org.festimate.domain.entity.Appearance;

import java.util.List;

public class SignUpRequest {

    @Size(max = 10, message = "이름은 10자를 초과할 수 없습니다.")
    @NotBlank(message = "유저 이름을 입력해주세요.")
    private final String username;

    @Size(max = 10, message = "닉네임은 10자를 초과할 수 없습니다.")
    @NotBlank(message = "닉네임을 입력해주세요.")
    private final String nickname;

    @NotNull(message = "나이를 입력해주세요.")
    private final Integer age;

    @Pattern(regexp = "^(남자|여자)$", message = "성별은 '남자' 또는 '여자' 만 입력 가능합니다.")
    @NotBlank(message = "성별을 입력해주세요.")
    private final String gender;

    @Size(max = 20, message = "학교 이름은 20자를 초과할 수 없습니다.")
    private final String school;

    @NotNull(message = "키를 입력해주세요.")
    private final Integer height;

    @NotBlank(message = "MBTI를 입력해주세요.")
    @Pattern(regexp = "^(INFP|INFJ|ENFP|ENFJ|INTP|INTJ|ENTP|ENTJ|ISFP|ISFJ|ESFP|ESFJ|ISTP|ISTJ|ESTP|ESTJ)$",
            message = "유효한 MBTI를 입력해주세요.")
    private final String mbti;

    @NotNull(message = "외모 특징을 입력해주세요.")
    @Size(min = 1, max = 2, message = "외모 특징은 최소 1개, 최대 2개까지 선택할 수 있습니다.")
    private final List<Appearance> appearanceList;

    public SignUpRequest(
            String username, String nickname, Integer age, String gender, String school, Integer height, String mbti, List<Appearance> appearanceList
    ) {
        this.username = username;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.school = school;
        this.height = height;
        this.mbti = mbti;
        this.appearanceList = appearanceList;
    }

    // Getters
    public String getUsername() { return username; }
    public String getNickname() { return nickname; }
    public Integer getAge() { return age; }
    public String getGender() { return gender; }
    public String getSchool() { return school; }
    public Integer getHeight() { return height; }
    public String getMbti() { return mbti; }
    public List<Appearance> getAppearanceList() { return appearanceList; }
}