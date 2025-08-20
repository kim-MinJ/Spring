package org.myclass.myboard.controller;

import org.myclass.myboard.dto.ComunityDto;
import org.myclass.myboard.dto.ComunitySearchDto;
import org.myclass.myboard.mapper.ComunityMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class MyBoardController {
    private ComunityMapper comunityMapper;

    @GetMapping("/")
    public String searchAll(Model model) {
        model.addAttribute("list", comunityMapper.selectAll());
        return "index";
    }

    @PostMapping("/searchAll")
    public String search(@ModelAttribute(name = "searchDto") ComunitySearchDto dto, Model model) {
        model.addAttribute("list", comunityMapper.searchAll(dto));
        return "index";
    }

}
