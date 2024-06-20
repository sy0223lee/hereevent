package com.multi.hereevent.category;

import com.multi.hereevent.category.interest.CategoryInterestService;
import com.multi.hereevent.dto.CategoryInterestDTO;
import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.event.interest.EventInterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes("member")
public class CategoryController {
    private final CategoryInterestService categoryService;
    private final EventInterestService eventService;

    /***** 관심 관리 *****/
    // 관심 목록 조회, 페이지 이동
    @GetMapping("/myinterest")
    public String myinterest(Model model) {
        MemberDTO member = (MemberDTO) model.getAttribute("member");
        if(member != null) {
            List<CategoryInterestDTO> categoryList = categoryService.selectCategoryInterestByMemberNo(member.getMember_no());
            List<EventDTO> eventList = eventService.selectEventInterestByMemberNo(member.getMember_no());
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("eventList", eventList);
            return "mypage/myinterest";
        }else{
            return "common/errorPage";
        }
    }

    // 관심 카테고리 추가
    @GetMapping("/myinterest/category/insert")
    public String insertCategoryInterest(@RequestParam("category_no") int category_no, Model model) {
        MemberDTO member = (MemberDTO) model.getAttribute("member");
        if(member != null) {
            int result = categoryService.insertCategoryInterest(category_no, member.getMember_no());
            if(result > 0) {
                return "redirect:/myinterest";
            }
        }
        return "common/errorPage";
    }
    // 관심 카테고리 삭제
    @GetMapping("/myinterest/category/delete")
    public String deleteCategoryInterest(@RequestParam("category_no") int category_no, Model model) {
        MemberDTO member = (MemberDTO) model.getAttribute("member");
        if(member != null) {
            int result = categoryService.deleteCategoryInterest(category_no, member.getMember_no());
            if(result > 0) {
                return "redirect:/myinterest";
            }
        }
        return "common/errorPage";
    }
}
