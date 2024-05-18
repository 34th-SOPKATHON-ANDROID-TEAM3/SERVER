package com.example.sopkathon.stone;

import com.example.sopkathon.common.exception.CustomException;
import com.example.sopkathon.common.exception.ErrorMessage;
import com.example.sopkathon.domain.Stone;
import com.example.sopkathon.domain.StoneJpaRepository;
import com.example.sopkathon.stone.controller.dto.GetSimpleStoneResponseDto;
import com.example.sopkathon.stone.controller.dto.GetStoneOfTodayResponseDto;
import com.example.sopkathon.stone.controller.dto.GetStoneResponseDto;
import com.example.sopkathon.stone.controller.dto.UpdateAnswerOfStoneRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StoneService {

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
        ).toList();
    }

    public GetStoneResponseDto getStone(Long stoneId) {
        Stone stone = stoneJpaRepository.findById(stoneId)
                .orElseThrow(() -> new CustomException(ErrorMessage.STONE_NOT_FOUND_EXCEPTION));

        if (stone.getAnswer() == null) {
            throw new CustomException(ErrorMessage.STONE_NOT_PRETTY);
        }
        return GetStoneResponseDto.of(stone);
    }

}
