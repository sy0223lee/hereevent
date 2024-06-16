package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("eventTime")
public class EventTimeDTO {
    private int event_time_no; // 이벤트 시간 번호
    private int event_no; // 이벤트 번호
    private String day; // 요일
    private String open_time; // 시작 시간
    private String close_time; // 종료 시간

    // insert 를 위한 생성자
    public EventTimeDTO(int event_no, String day, String open_time, String close_time) {
        this.event_no = event_no;
        this.day = day;
        this.open_time = open_time;
        this.close_time = close_time;
    }
}
