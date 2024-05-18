package com.example.sopkathon.stone;

import com.example.sopkathon.domain.Stone;
import com.example.sopkathon.domain.StoneJpaRepository;
import com.example.sopkathon.stone.controller.dto.GetSimpleStoneResponseDto;
import com.example.sopkathon.stone.controller.dto.GetStoneOfTodayResponseDto;
import com.example.sopkathon.stone.controller.dto.UpdateAnswerOfStoneRequestDto;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<GetSimpleStoneResponseDto> getAllSimpleStone() {
        return stoneJpaRepository.findAllByOrderById().stream().map(
                stone -> {
                    boolean isPretty;
                    String stoneImage;
                    if (stone.getAnswer() != null) {
                        isPretty = true;
                        stoneImage = stone.getPrettyImage();
                    } else {
                        isPretty = false;
                        stoneImage = "tmp";
                    }
                    return new GetSimpleStoneResponseDto(stone.getId(), isPretty, stoneImage);
                }
        ).collect(Collectors.toList());
    }

}
