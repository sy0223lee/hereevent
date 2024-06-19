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

    // select 할 때 추가로 필요한 멤버 변수
    private String nick; // 멤버 닉네임
    private String img_path; // 멤버 프로필 또는 이벤트 이미지
    private String name; // 이벤트 이름
}
