package com.example.sopkathon.stone;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.sopkathon.domain.Stone;
import com.example.sopkathon.domain.StoneJpaRepository;
import com.example.sopkathon.stone.controller.dto.GetSimpleStoneResponseDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StoneServiceTest {

    @Mock
    private StoneJpaRepository repository;

    @InjectMocks
    private StoneService stoneService;

    @Test
    @DisplayName("답변이 있는 돌은 예쁜 돌 사진을, 답변이 없는 돌을 못생긴 돌 실루엣을 반환한다")
    void getAllSimpleStone() {
        Stone fakeStone1 = Stone.buildWithId().id(1L).uglyImage("uglyImage").prettyImage("prettyImage1").question("질문1")
                .answer("답변1").build();
        Stone fakeStone2 = Stone.buildWithId().id(2L).uglyImage("uglyImage").prettyImage("prettyImage2").question("질문2")
                .answer("답변2").build();
        Stone fakeStone3 = Stone.buildWithId().id(3L).uglyImage("uglyImage").prettyImage("prettyImage3").question("질문3")
                .answer(null).build();

        Mockito.when(repository.findAllByOrderById()).thenReturn(List.of(fakeStone1, fakeStone2, fakeStone3));

        List<GetSimpleStoneResponseDto> responseDtos = stoneService.getAllSimpleStone();

        assertThat(responseDtos.get(0).stoneImage()).isEqualTo("prettyImage1");
        assertThat(responseDtos.get(1).stoneImage()).isEqualTo("prettyImage2");
        assertThat(responseDtos.get(2).stoneImage()).isEqualTo(StoneService.UGLY_IMAGE_URL);
    }
}