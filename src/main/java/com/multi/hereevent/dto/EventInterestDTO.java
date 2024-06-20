package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("eventInterest")
public class EventInterestDTO {
    private int event_interest_no;
    private int event_no;
    private int member_no;
}
