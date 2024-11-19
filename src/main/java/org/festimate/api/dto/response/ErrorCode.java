package org.festimate.api.dto.response;

public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "e4000", "유효하지 않은 요청입니다."),
    INVALID_INPUT_HTTP(405, "e4050", "잘못된 HTTP method 요청입니다."),
    INVALID_INPUT_USER_DUPLICATE(409, "e4090", "이미 존재하는 회원입니다."),
    INTERNAL_SERVER_ERROR(500, "e5000", "서버 내부 오류입니다.");

    private final int code;
    private final String customCode;
    private final String message;

    ErrorCode(int code, String customCode, String message) {
        this.code = code;
        this.customCode = customCode;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getCustomCode() {
        return customCode;
    }

    public String getMessage() {
        return message;
    }
}