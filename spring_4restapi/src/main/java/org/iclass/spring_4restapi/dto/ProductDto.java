package org.iclass.spring_4restapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ProductDto {
    @NotBlank(message = "pcode 는 필수값 입니다.")
    @Pattern(regexp = "^[A-Za-z0-9]{4,}$", message = "영문자와 숫자로 구성된 4글자 이상 이어야 합니다.")
    private final String pcode;

    @NotBlank(message = "category 는 필수값 입니다.")
    private final String category;
    private final String pname;
    private final Integer price;
}
