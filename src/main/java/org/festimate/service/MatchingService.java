package org.festimate.service;

import org.festimate.api.dto.response.ErrorCode;
import org.festimate.api.exception.CustomException;
import org.festimate.domain.entity.Appearance;
import org.festimate.domain.entity.Matching;
import org.festimate.domain.entity.User;
import org.festimate.domain.repository.MatchingRepository;
import org.festimate.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchingService {
    private final MatchingRepository matchingRepository;
    private final UserRepository userRepository;

    public MatchingService(MatchingRepository matchingRepository, UserRepository userRepository) {
        this.matchingRepository = matchingRepository;
        this.userRepository = userRepository;
    }

    // 매칭 등록하기
    public Long applyMatching(
            Long userId, Integer minHeight, Integer maxHeight, Integer minAge, Integer maxAge, String mbti,
            List<String> appearanceList, List<Integer> questionList, List<String> timeList, String dress
    ) {
        // 존재하는 멤버인지 체크
        User user = findByIdOrThrow(userId);

        Matching savedMatching = matchingRepository.save(
                new Matching(user, minHeight, maxHeight, minAge, maxAge, mbti, mapAppearanceList(appearanceList),
                        questionList, timeList, dress)
        );
        return savedMatching.getId();
    }

    // ID로 유저 조회
    private User findByIdOrThrow(final Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );
    }

    // 이상형 외모 String List를 enum으로 변환
    private List<Appearance> mapAppearanceList(List<String> appearanceList) {
        try {
            return appearanceList.stream().map(Appearance::valueOf).toList();
        } catch (IllegalArgumentException ex) {
            throw new CustomException(ErrorCode.INVALID_INPUT_VALUE);
        }
    }
}
