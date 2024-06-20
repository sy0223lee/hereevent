package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("categoryInterest")
public class CategoryInterestDTO {
    private int category_interest_no;
    private int category_no;
    private int member_no;

    // 회원이 관심있는 카테고리의 이름을 저장할 멤버 변수
    private String name;
}
