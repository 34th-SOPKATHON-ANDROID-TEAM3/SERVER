package com.example.sopkathon.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

    STONE_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND.value(), "존재하지 않는 돌입니다"),
    STONE_NOT_PRETTY(HttpStatus.NOT_FOUND.value(), "답변이 존재하지 않는 돌입니다")
    ;

    private final int status;
    private final String message;
}
