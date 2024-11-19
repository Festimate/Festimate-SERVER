package org.festimate.api.exception;

import org.festimate.api.dto.response.ErrorCode;

public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;

    // ErrorCode의 기본 메시지를 사용하는 생성자
    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    // 내가 만든 메시지를 전달할 수 있는 생성자 ㅋㅋ
    public CustomException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}