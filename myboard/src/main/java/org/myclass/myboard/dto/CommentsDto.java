package org.myclass.myboard.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CommentsDto {
    private int idx;
    private int mref;
    private String writer;
    private String content;
    private Date createDate;
    private Integer ip;
    private Integer heart;
}
