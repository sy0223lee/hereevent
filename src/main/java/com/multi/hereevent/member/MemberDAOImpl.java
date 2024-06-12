package com.multi.hereevent.member;

import com.multi.hereevent.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {
    private final SqlSession sqlSession;

    @Override
    public MemberDTO memberLogin(MemberDTO member) {
        System.out.println("[MemberDAO] " + member);
        return sqlSession.selectOne("com.multi.hereevent.member.login", member);
    }

    @Override
    public int memberInsert(MemberDTO member) {
        return 0;
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
