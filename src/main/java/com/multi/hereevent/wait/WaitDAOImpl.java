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
        return sqlSession.selectOne("com.multi.hereevent.wait.login", wait);
    }

    @Override
    public WaitDTO findByWaitTelAndState(String wait_tel) {
        return sqlSession.selectOne("com.multi.hereevent.wait.check",wait_tel);
    }


    @Override
    public int waitInsert(WaitDTO wait) {
        return sqlSession.insert("com.multi.hereevent.wait.insert",wait);
    }

    @Override
    public int delete(String wait_no) {
        return sqlSession.delete("com.multi.hereevent.wait.delete", wait_no);
    }

    @Override
    public List<WaitDTO> getWaitList() {
        return sqlSession.selectList("com.multi.hereevent.wait.selectall");
    }

    @Override
    public WaitDTO read(String wait_no) {
        return sqlSession.selectOne("com.multi.hereevent.wait.read", wait_no);
    }

    @Override
    public WaitDTO waitDetail(int wait_no) {
        return sqlSession.selectOne("com.multi.hereevent.wait.detail",wait_no);
    }


}
