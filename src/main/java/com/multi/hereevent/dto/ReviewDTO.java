package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("review")
public class ReviewDTO {
    private int review_no;
    private int event_no;
    private int member_no;
    private Date write_date;
    private Date update_date;
    private String content;
    private float star;

    // 리뷰 작성자 정보 저장할 멤버변수
    private String nick;
    private String img_path;
}
