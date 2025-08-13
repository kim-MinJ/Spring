package org.iclass.spring_1demo.old;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoDao {
    private String message;

    public DemoDao() {
        this.message = "Hello, Spring!!";
        log.info("DeomoDao 생성자-message : {}", this.message);
    }
}
