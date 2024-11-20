package org.festimate.api.controller;

import org.festimate.api.dto.request.MatchingRequest;
import org.festimate.api.dto.response.MatchingResponse;
import org.festimate.service.MatchingService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/festimate/v1")
public class MatchingController {

    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    // 매칭 등록하기
    @PostMapping("/matching")
    public ResponseEntity<MatchingResponse> applyMatching(
            @RequestHeader("userId") Long userId,
            @Validated @RequestBody MatchingRequest matchingRequest
    ) {
        long appliedMatchingId = matchingService.applyMatching(
                userId,
                matchingRequest.getMinHeight(),
                matchingRequest.getMaxHeight(),
                matchingRequest.getMinAge(),
                matchingRequest.getMaxAge(),
                matchingRequest.getMbti(),
                matchingRequest.getAppearanceList(),
                matchingRequest.getQuestionList(),
                matchingRequest.getTimeList(),
                matchingRequest.getDress()
        );
        return ResponseEntity.ok(new MatchingResponse(appliedMatchingId));
    }

}
