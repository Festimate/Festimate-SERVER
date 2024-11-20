package org.festimate.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class MatchingRequest {

    @NotNull(message = "최소 키를 입력해주세요.")
    private Integer minHeight;

    @NotNull(message = "최대 키를 입력해주세요.")
    private Integer maxHeight;

    @NotNull(message = "최소 나이를 입력해주세요.")
    private Integer minAge;

    @NotNull(message = "최대 나이를 입력해주세요.")
    private Integer maxAge;

    @NotNull(message = "MBTI를 입력해주세요.")
    private String mbti;

    @NotNull(message = "외모 타입을 입력해주세요.")
    private List<String> appearanceList;

    @NotNull(message = "답변 리스트를 입력해주세요.")
    @Size(min = 5, max = 5, message = "답변 리스트는 정확히 5개의 답변이어야 합니다.")
    private List<Integer> questionList;

    @NotNull(message = "시간 리스트를 입력해주세요.")
    private List<String> timeList;

    @NotNull(message = "의상을 입력해주세요.")
    private String dress;

    public MatchingRequest(Integer minHeight, Integer maxHeight, Integer minAge, Integer maxAge, String mbti,
                           List<String> appearanceList, List<Integer> questionList, List<String> timeList, String dress) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.mbti = mbti;
        this.appearanceList = appearanceList;
        this.questionList = questionList;
        this.timeList = timeList;
        this.dress = dress;
    }

    // Getters
    public Integer getMinHeight() {
        return minHeight;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public String getMbti() {
        return mbti;
    }

    public List<String> getAppearanceList() {
        return appearanceList;
    }

    public List<Integer> getQuestionList() {
        return questionList;
    }

    public List<String> getTimeList() {
        return timeList;
    }

    public String getDress() {
        return dress;
    }
}
