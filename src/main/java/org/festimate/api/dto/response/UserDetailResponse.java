package org.festimate.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 포함하지 않음
public record UserDetailResponse(String nickname, String school) {
}
