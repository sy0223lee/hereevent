package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("eventInterest")
public class EventInterestDTO {
    private int event_interest_no;
    private int event_no;
    private int member_no;

    // 이벤트 정보 저장을 위한 멤버 변수
    private String name;
    private Date start_date;
    private Date end_date;
    private String addr;
    private String img_path;
}
