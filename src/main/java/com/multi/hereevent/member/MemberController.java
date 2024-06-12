package com.multi.hereevent.member;

import com.multi.hereevent.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /***** 마이페이지 *****/
    @GetMapping("/mypage")
    public String mypage() {
        return "mypage/mypage";
    }
    @GetMapping("/mypage/edit-nick")
    public String editNickPage() {
        return "mypage/edit_nick";
    }
    @PostMapping("/mypage/edit-nick")
    public String editNick(@RequestParam("nick") String nick) {

        return "mypage/mypage";
    }
    @PostMapping(value = "/mypage/check-nick", produces = "application/text; charset=utf-8")
    @ResponseBody
    public String checkNick(@RequestParam("nick") String nick) {
        boolean available = service.memberCheckNick(nick);
        if (available) {
            return "사용 가능한 닉네임";
        }else {
            return "사용 불가능한 닉네임";
        }
    }

    /***** 관심 관리 *****/
    @GetMapping("/myinterest")
    public String myinterest() {
        return "mypage/myinterest";
    }

    /***** 후기 관리 *****/
    @GetMapping("/myreview")
    public String myreview() {
        return "mypage/myreview";
    }

    /***** 행사 내역 *****/
    @GetMapping("/myevent")
    public String myevent() {
        return "mypage/myevent";
    }
}
