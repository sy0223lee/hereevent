package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.dto.WaitDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class WaitDAOImpl implements WaitDAO {
    private final SqlSession sqlSession;

    @Override
    public WaitDTO waitLogin(WaitDTO wait) {
        return sqlSession.selectOne("com.multi.hereevent.wait.waitLogin", wait);
    }

    @Override
    public int waitInsert(WaitDTO wait) {
        return 0;
    }

    @Override
    public List<WaitDTO> waitList() {
        return List.of();
    }

    @Override
    public WaitDTO waitDetail(int wait_no) {
        return sqlSession.selectOne("com.multi.hereevent.wait.detail",wait_no);
    }


}
