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
public class ComunitySearchDto {
    private String title;
    private String writer;
    private String content;
}
