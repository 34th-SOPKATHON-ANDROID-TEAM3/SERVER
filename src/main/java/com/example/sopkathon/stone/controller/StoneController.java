package com.example.sopkathon.stone.controller;

import com.example.sopkathon.stone.StoneService;
import com.example.sopkathon.stone.controller.dto.GetSimpleStoneResponseDto;
import com.example.sopkathon.stone.controller.dto.GetStoneOfTodayResponseDto;
import com.example.sopkathon.stone.controller.dto.GetStoneResponseDto;
import com.example.sopkathon.stone.controller.dto.UpdateAnswerOfStoneRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/stones")
@RestController
public class StoneController {

    private final StoneService stoneService;

    @GetMapping("/today")
    public ResponseEntity<GetStoneOfTodayResponseDto> getStoneOfToday() {
        return ResponseEntity.ok(stoneService.getStoneOfToday());
    }

    @PatchMapping("/today")
    public ResponseEntity<Void> updateAnswerStoneOfToday(
            @RequestBody UpdateAnswerOfStoneRequestDto request
    ) {
        stoneService.updateAnswerOfStone(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<GetSimpleStoneResponseDto>> getAllSimpleStone() {
        return ResponseEntity.ok(stoneService.getAllSimpleStone());
    }

    @GetMapping("/{stoneId}")
    public ResponseEntity<GetStoneResponseDto> getStone(
            @PathVariable Long stoneId
    ) {
        return ResponseEntity.ok(stoneService.getStone(stoneId));
    }
}
