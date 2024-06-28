package com.multi.hereevent.event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_no")
    private Long id;

    private Integer category_no;
    private String name;
    private Date start_date;
    private Date end_date;
    private String addr;
    private String info;
    private String homepage;
    private String sns;
    private String img_path;
    private String type;
    private Integer reserve_limit;
    private Integer wait_limit;
}
