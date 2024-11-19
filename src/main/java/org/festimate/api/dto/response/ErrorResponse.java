package org.festimate.api.dto.response;

/*
에러 응답을 정의한 클래스
 */
public class ErrorResponse {
    private final Integer status;
    private final ErrorDetail error;

    // 기본 메시지 생성
    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getCode();
        this.error = new ErrorDetail(errorCode.getCustomCode(), errorCode.getMessage());
    }

    // 커스텀 메시지 생성
    public ErrorResponse(ErrorCode errorCode, String customMessage) {
        this.status = errorCode.getCode();
        this.error = new ErrorDetail(errorCode.getCustomCode(),
                customMessage != null ? customMessage : errorCode.getMessage());
    }

    public int getStatus() {
        return status;
    }

    public ErrorDetail getError() {
        return error;
    }
}