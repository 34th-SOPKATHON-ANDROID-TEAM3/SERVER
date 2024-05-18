package com.example.sopkathon.stone;

import com.example.sopkathon.domain.Stone;
import com.example.sopkathon.domain.StoneJpaRepository;
import com.example.sopkathon.stone.controller.dto.GetStoneOfTodayResponseDto;
import com.example.sopkathon.stone.controller.dto.UpdateAnswerOfStoneRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class JunseoStoneService {

    private final StoneJpaRepository stoneJpaRepository;

    public GetStoneOfTodayResponseDto getStoneOfToday() {
        return GetStoneOfTodayResponseDto.of(stoneJpaRepository.findFirstByOrderByIdDesc());
    }

    @Transactional
    public void updateAnswerOfStone(UpdateAnswerOfStoneRequestDto request) {
        Stone todayStone = stoneJpaRepository.findFirstByOrderByIdDesc();
        todayStone.setAnswer(request.answer());
    }

}
