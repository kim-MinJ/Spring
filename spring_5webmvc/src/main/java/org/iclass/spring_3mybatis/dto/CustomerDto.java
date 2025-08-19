package org.iclass.spring_3mybatis.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder // 커스텀 생성자 대신에 사용.
@Getter
@Setter
@ToString
// @AllArgsConstructor // 모든 프로퍼티값 초기화하는 생성자 코드
@RequiredArgsConstructor // final 키워드 변수만 초기화 생성
public class CustomerDto {
    private final String customerId;
    private final String name;
    private final String email;
    private final Integer age; // int 로 하면 안되는 경우 : null 값이 있을때 (int에 저장 못합니다.)
    private final Date regDate;
}
/*
 * 자바의 날짜 타입은
 * 자바 8버전 이전 : java.util.Date
 * -> 타임리프 날짜 출력 기능의 객체를 #date 유틸리티로 사용
 * 이후 : java.time.LocalDate, LocalTime
 * -> 타임리프 날짜 출력 기능의 객체를 #temporals 유틸리티로 사용
 */
