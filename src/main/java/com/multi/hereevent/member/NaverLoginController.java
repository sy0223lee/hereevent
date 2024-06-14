package com.multi.hereevent.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaverLoginController {
    @GetMapping("/login/naver")
    public String naverLogin() {
        return "naverLogin";
    }
}
