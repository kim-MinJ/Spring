package org.iclass.spring_5webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController_1View {

    @GetMapping("/login")
    public void login() {
        // view 파일의 이름은 자동으로 url 이름과 동일하게 찾습니다.
        // ㄴ ViewResolver 의 역할
    }

    @GetMapping("/join")
    public String register() {
        // view 파일의 이름은 join.html 로 찾아갑니다.
        return "join";
    }
}
