package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("reservation")
public class ReservationDTO {
    private int reserve_no;
    private int event_no;
    private int member_no;
    private Date reserve_date;
    private Time reserve_time;
    private String state;

}
