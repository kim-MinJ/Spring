package org.iclass.spring_2di.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BuyDao {
    private List<String> sales;

    // List<String> 타입의 bean이 존재하면
    public BuyDao(List<String> sales) {
        // 또는 @Qualifier("foodBean") 또는 어노테이션 없음
        this.sales = sales;
        log.info("BuyDao 생성자 - sales : {}", this.sales);
    }

    // 만약 Bean이 2가지 이상있는다면?
    // public BuyDao(@Qualifier("drinkBean") List<String> sales) {
    // this.sales = sales;
    // log.info("BuyDao 생성자 - sales : {}", this.sales);
    // }
}