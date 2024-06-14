package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("page")

    public class EventDTO {
    private int event_no;
    private int category_no;
    private String name;
    private Date start_date;
    private Date end_date;
    private String info;
    private String homepage;
    private String sns;
    private String img_path;
    private int type;
    private int reserve_limit;
    private int wait_limit;
    }
