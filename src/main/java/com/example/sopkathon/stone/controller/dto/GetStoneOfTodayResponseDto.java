package com.example.sopkathon.stone.controller.dto;

import com.example.sopkathon.domain.Stone;

public record GetStoneOfTodayResponseDto(
        String uglyImage,
        String prettyImage,
        String question
) {
    public static GetStoneOfTodayResponseDto of(Stone stone) {
        return new GetStoneOfTodayResponseDto(stone.getUglyImage(), stone.getPrettyImage(), stone.getQuestion());
    }
}
