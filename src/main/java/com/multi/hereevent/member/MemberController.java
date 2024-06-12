package com.multi.hereevent.member;

import com.multi.hereevent.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequiredArgsConstructor
@SessionAttributes("member")
public class MemberController {
    private final MemberService service;

    @PostMapping("/login")
    public String login(MemberDTO member, Model model) {
        MemberDTO loginMember = service.memberLogin(member);
        model.addAttribute("member", loginMember);
        return "redirect:/mypage";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login/login";
    }
    @GetMapping("/register")
    public String register() {
        return "login/register";
    }
    @PostMapping("/insert")
    public String register(MemberDTO member){
        System.out.println(member);
        service.memberInsert(member);
        return "redirect:/login";
    }
    @GetMapping("/mypage")
    public String mypage() {
        return "mypage/mypage";
    }
}
