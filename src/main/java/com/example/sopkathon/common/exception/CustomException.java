package com.example.sopkathon.common.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorMessage errorMessage;

    public CustomException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorStatusResponse toErrorResponse() {
        return new ErrorStatusResponse(errorMessage.getStatus(), errorMessage.getMessage());
    }
}
