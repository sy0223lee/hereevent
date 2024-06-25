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
    private int member_no;
    private int category1;
    private int category2;
    private int category3;

    // 회원이 관심있는 카테고리의 이름을 저장할 멤버 변수
    private String name;

    public CategoryInterestDTO(int category_interest_no, int member_no, int category1, int category2, int category3) {
        this.category_interest_no = category_interest_no;
        this.member_no = member_no;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
    }
}

