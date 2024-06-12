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
        System.out.println("[MemberController] " + member);
        MemberDTO loginMember = service.memberLogin(member);
        System.out.println("[loginMember] " + loginMember);
        model.addAttribute("member", loginMember);
        return "redirect:/mypage";
    }

    @GetMapping("/mypage")
    public String mypage() {
        return "mypage/mypage";
    }
}
