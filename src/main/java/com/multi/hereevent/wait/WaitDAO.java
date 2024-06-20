package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.dto.WaitDTO;

import java.util.List;

public interface WaitDAO {
    //대기 확인을 위한 로그인
    WaitDTO waitLogin(WaitDTO wait);
    //대기 등록
    int waitInsert(WaitDTO wait);
    //대기 삭제
    List<WaitDTO> waitList();
    //wait_no로 세부정보 가져오기
    WaitDTO waitDetail(int wait_no);

}
