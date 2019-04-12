package com.hee.daily_photolog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8080/daily-photolog/app/hello
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("name", "홍길동");
    }
}