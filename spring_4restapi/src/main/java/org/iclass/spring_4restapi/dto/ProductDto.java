package org.iclass.spring_4restapi.dto;

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
