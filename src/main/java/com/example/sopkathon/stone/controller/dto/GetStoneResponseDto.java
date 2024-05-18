package com.example.sopkathon.stone.controller.dto;

import com.example.sopkathon.domain.Stone;

public record GetStoneResponseDto(
        Long id,
        String question,
        String answer,
        String stoneImage
) {

    public static GetStoneResponseDto of(Stone stone) {
        return new GetStoneResponseDto(stone.getId(), stone.getQuestion(), stone.getAnswer(), stone.getPrettyImage());

    }
}
