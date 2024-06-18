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
        return sqlSession.selectOne("com.multi.hereevent.member.login", member);
    }

    @Override
    public int memberInsert(MemberDTO member) {
        return sqlSession.insert("com.multi.hereevent.member.insert",member);
    }

    @Override
    public List<MemberDTO> memberList() {
        return List.of();
    }

    @Override
    public MemberDTO memberDetail(int member_no) {
        return sqlSession.selectOne("com.multi.hereevent.member.detail", member_no);
    }

    @Override
    public int memberUpdateNick(MemberDTO member) {
        return sqlSession.update("com.multi.hereevent.member.updateNick", member);
    }

    @Override
    public int memberUpdateBirth(MemberDTO member) {
        return sqlSession.update("com.multi.hereevent.member.updateBirth", member);
    }

    @Override
    public int memberUpdateProfileImg(MemberDTO member) {
        return sqlSession.update("com.multi.hereevent.member.updateProfileImg", member);
    }

    @Override
    public int memberDelete(int member_no) {
        return 0;
    }

    @Override
    public boolean memberCheckNick(String nick) {
        MemberDTO member = sqlSession.selectOne("com.multi.hereevent.member.checkNick", nick);
        return member == null; // 조회된 회원이 없으면 사용 가능한 닉네임 이므로 true 반환
    }

    @Override
    public MemberDTO memberFindByEmail(String email) {
        return sqlSession.selectOne("com.multi.hereevnet.member.findByEmail", email);
    }
}
