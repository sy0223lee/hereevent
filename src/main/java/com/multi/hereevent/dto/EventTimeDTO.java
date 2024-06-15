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
    private int day; // 요일
    private int open_time; // 시작 시간
    private int close_time; // 종료 시간
}
