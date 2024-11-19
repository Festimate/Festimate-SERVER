package org.festimate.api.dto.response;

public class ErrorDetail {
    private final String customCode;
    private final String message;

    public ErrorDetail(String customCode, String message) {
        this.customCode = customCode;
        this.message = message;
    }

    public String getCustomCode() {
        return customCode;
    }

    public String getMessage() {
        return message;
    }
}