package com.example.sopkathon.stone;

import com.example.sopkathon.domain.StoneJpaRepository;
import com.example.sopkathon.stone.controller.dto.GetStoneOfTodayResponseDto;
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

}
