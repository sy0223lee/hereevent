package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("reviewImg")
public class ReviewImgDTO {
    private int review_img_no;
    private int review_no;
    private String img_path;

    // 이미지 저장을 위한 생성자
    public ReviewImgDTO(String img_path) {
        this.img_path = img_path;
    }
}
