package com.multi.hereevent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO{

    private Long event_no;
    private String name;
    private String addr;
    private String img_path;

}