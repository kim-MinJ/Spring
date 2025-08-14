package org.iclass.spring_4restapi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.spring_4restapi.dto.BuyDto;
import org.iclass.spring_4restapi.dto.CustomerBuyDto;
import org.springframework.stereotype.Component;

@Mapper // dao 역할을 하는 인터페이스
public interface BuyMapper {
    List<BuyDto> selectByCustomer(String customer_id);

    List<BuyDto> selectByPcode(String pcode);

    List<BuyDto> selectByYear(String year); // 내 방식은 int year

    int selectSumByPcode(String pcode);

    // join
    List<CustomerBuyDto> selectSaleByCustomer(String customer_idString);

    // count 집계함수
    Map<String, Integer> selectCountByYear(String year);

    List<Map<String, Object>> selectAllCountByYear();

}