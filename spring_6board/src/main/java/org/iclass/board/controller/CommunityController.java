package org.iclass.board.controller;

import java.util.List;

import org.iclass.board.dto.CommunityDTO;
import org.iclass.board.mapper.CommunityMapper;
import org.iclass.board.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class CommunityController {
    private CommunityService service;

    @GetMapping("/community/list")
    public String list(Model model) {
        model.addAttribute("list", service.selectAll());
        return "community/list"; // templates/community/list.html 찾음
    }

    @GetMapping("community/read")
    public String read(@RequestParam long idx, Model model) {
        CommunityDTO dto = service.read(idx, true);
        model.addAttribute("dto", dto);
        return "community/read";
    }

    @GetMapping("community/write")
    public String writeform() {
        return "community/write";
    }

    @PostMapping("community/write")
    public String write(CommunityDTO dto) {
        service.write(dto);
        return "redirect:/";
    }

    @GetMapping("community/update")
    public String updateform(@RequestParam long idx, Model model) {
        CommunityDTO dto = service.read(idx, false);
        model.addAttribute("dto", dto);
        return "community/update";
    }

    @PostMapping("community/update")
    public String update(CommunityDTO dto) {
        service.save(dto);
        return "redirect:/";
    }

    @PostMapping("community/delete")
    public String delete(@RequestParam long idx) {
        service.remove((int) idx);
        return "redirect:/";
    }

}
