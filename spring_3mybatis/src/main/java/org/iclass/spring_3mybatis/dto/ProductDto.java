package org.iclass.spring_3mybatis.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ProductDto {
    private final String pcode;
    private final String category;
    private final String pname;
    private final int price;
}
