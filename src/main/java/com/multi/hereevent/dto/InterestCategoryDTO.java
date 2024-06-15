package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("ic")
public class InterestCategoryDTO {
    private int category_interest_no;
    private int category_no;
    private int member_no;
}
