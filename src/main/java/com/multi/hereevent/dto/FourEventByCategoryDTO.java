package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("fourEvent")
//카테고리별 이벤트 4개씩 뽑기위한 DTO
public class FourEventByCategoryDTO {
    private int category_no; // 카테고리 번호가 1이면
    private String name;
    private List<EventDTO> eventList; // 카테고리 번호가 1인 이벤트 4개를 리스트로 저장
}