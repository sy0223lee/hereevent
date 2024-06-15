package com.multi.hereevent.member;

import com.multi.hereevent.dto.InterestCategoryDTO;
import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.fileupload.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Member;
import java.sql.Date;

@Controller
@RequiredArgsConstructor
@SessionAttributes("member")
public class MemberController {
    private final MemberService service;
    private final FileUploadService fileService;

    /***** 로그인, 회원가입 *****/
    //로그인
    @GetMapping("/login")
    public String loginPage(){
        return "login/login";
    }
    @PostMapping("/login")
    public String login(MemberDTO member, Model model) {
        MemberDTO loginMember = service.memberLogin(member);
        model.addAttribute("member", loginMember);
        return "redirect:/mypage";
    }
    //회원가입
    @GetMapping("/register")
    public String register() {
        return "login/register";
    }
    @PostMapping("/insert")
    public String register(MemberDTO member, Model model){
        service.memberInsert(member);
        MemberDTO regiMember = service.memberLogin(member);
        System.out.println(regiMember);
        model.addAttribute("member", regiMember);
        return "redirect:/setCategory";
    }
    //관심 카테고리 등록
    @GetMapping("/setCategory")
    public String setCategoryPage(MemberDTO member,Model model){
        MemberDTO regiMember = service.memberLogin(member);
        model.addAttribute("member", regiMember);
        System.out.println("카테고리설정================================"+regiMember);
        return "login/set_category";
    }
    @PostMapping("/setCategory")
    public String setCategory(InterestCategoryDTO ic){
        service.memberSetCategory(ic);
        return "redirect:/login";
    }
    // 이메일 중복 확인
    @PostMapping(value = "/mypage/check-email", produces = "application/text; charset=utf-8")
    @ResponseBody
    public String checkEmail(@RequestParam("email") String email) {
        boolean available = service.memberCheckEmail(email);
        if (available) {
            return "사용 가능한 이메일";
        }else {
            return "이메일이 중복됩니다";
        }
    }

    /***** 마이페이지 *****/
    @GetMapping("/mypage")
    public String mypage() {
        return "mypage/mypage";
    }
    // 닉네임 수정 페이지 이동
    @GetMapping("/mypage/edit-nick")
    public String editNickPage() {
        return "mypage/edit_nick";
    }
    // 닉네임 수정
    @PostMapping("/mypage/edit-nick")
    public String editNick(MemberDTO member, Model model) {
        int result = service.memberUpdateNick(member);
        if(result > 0) {
            model.addAttribute("member", service.memberDetail(member.getMember_no()));
            return "redirect:/mypage";
        }else{
            return "common/error_page";
        }
    }
    // 닉네임 중복 확인
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
    // 생일 수정 페이지 이동
    @GetMapping("/mypage/edit-birth")
    public String editBirthPage() {
        return "mypage/edit_birth";
    }
    // 생일 수정
    @PostMapping("/mypage/edit-birth")
    public String editBirth(MemberDTO member, Model model) {
        int result = service.memberUpdateBirth(member);
        if(result > 0) {
            model.addAttribute("member", service.memberDetail(member.getMember_no()));
            return "redirect:/mypage";
        }else {
            return "common/error_page";
        }
    }
    // 프로필 사진 수정 페이지 이동
    @GetMapping("/mypage/edit-profile-img")
    public String editProfileImgPage(){
        return "mypage/edit_profile_img";
    }
    // 프로필 사진 수정
    @PostMapping("/mypage/edit-profile-img")
    public String editProfileImg(MemberDTO member, Model model) {
        System.out.println("[editProfileImg] member = " + member);
        MultipartFile profileImg = member.getProfile_img();
        String storeFilename = null;
        try {
            storeFilename = fileService.uploadProfileImg(profileImg);
            member.setImg_path(storeFilename);
            service.memberUpdateProfileImg(member);
            model.addAttribute("member", service.memberDetail(member.getMember_no()));
            return "redirect:/mypage";
        } catch (IOException e) {
            e.printStackTrace();
            return "common/error_page";
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
