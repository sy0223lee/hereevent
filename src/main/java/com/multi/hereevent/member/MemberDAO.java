package com.multi.hereevent.member;

import com.multi.hereevent.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    public MemberDTO memberLogin(MemberDTO member);
    public int memberInsert(MemberDTO member);
    public List<MemberDTO> memberList();
    public MemberDTO memberDetail(int member_no);
    public int memberUpdate(int member_no);
    public int memberDelete(int member_no);
}
