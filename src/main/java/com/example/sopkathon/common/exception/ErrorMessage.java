package com.example.sopkathon.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

    ;

    private final int status;
    private final String message;
}
