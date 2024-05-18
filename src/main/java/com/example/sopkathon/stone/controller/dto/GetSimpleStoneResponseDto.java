package com.example.sopkathon.stone.controller.dto;

public record GetSimpleStoneResponseDto(
        Long id,
        boolean isPretty,
        String stoneImag
) {
}
