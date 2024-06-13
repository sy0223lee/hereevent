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

    public class PageDTO {
        private int eventNo;
        private int categoryNo;
        private String name;
        private Date startDate;
        private Date endDate;
        private String addr;
        private String info;
        private String homepage;
        private String sns;
        private String imgPath;
        private int type;
        private int reserveLimit;
        private int waitLimit;
    }
