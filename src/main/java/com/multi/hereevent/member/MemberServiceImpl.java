package com.multi.hereevent.member;

import com.multi.hereevent.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberDAO dao;

    @Override
    public MemberDTO memberLogin(MemberDTO member) {
        return dao.memberLogin(member);
    }

    @Override
    public int memberInsert(MemberDTO member) {
        return dao.memberInsert(member);
    }

    @Override
    public List<MemberDTO> memberList() {
        return List.of();
    }

    @Override
    public MemberDTO memberDetail(int member_no) {
        return null;
    }

    @Override
    public int memberUpdate(int member_no) {
        return 0;
    }

    @Override
    public int memberDelete(int member_no) {
        return 0;
    }
}
