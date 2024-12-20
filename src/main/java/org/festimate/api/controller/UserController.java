package org.festimate.api.controller;

import jakarta.validation.Valid;
import org.festimate.api.dto.request.SignUpRequest;
import org.festimate.api.dto.response.UserDetailResponse;
import org.festimate.api.dto.response.UserResponse;
import org.festimate.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/festimate/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signup(
            @Valid @RequestBody SignUpRequest signupRequest
    ) {
        Long userId = userService.signupUser(signupRequest.getUsername(), signupRequest.getNickname(), signupRequest.getAge(), signupRequest.getGender(), signupRequest.getSchool(), signupRequest.getHeight(), signupRequest.getMbti(), signupRequest.getAppearanceList());
        return ResponseEntity.ok(new UserResponse(userId));
    }

    @GetMapping("/user-detail")
    public ResponseEntity<UserDetailResponse> getUserDetails(
            @Valid @RequestHeader("userId") Long userId
    ) {
        UserDetailResponse userDetail = userService.getUserDetailById(userId);
        return ResponseEntity.ok(userDetail);
    }

    @PostMapping("/check-nickname")
    public ResponseEntity<Void> checkNickname(
            @Valid @RequestParam("nickname") String nickname
    ) {
        userService.existsByNickname(nickname);
        return ResponseEntity.ok().build();
    }
}
