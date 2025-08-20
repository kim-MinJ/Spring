package org.myclass.myboard.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ComunityDto {
    private int idx;
    private String writer;
    private String title;
    private String content;
    private Integer readcount;
    private Date createDate;
    private String ip;
    private Integer commentCount;
}
