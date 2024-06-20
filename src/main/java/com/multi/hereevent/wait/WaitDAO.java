package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.MemberDTO;
import com.multi.hereevent.dto.WaitDTO;

import java.util.List;

public interface WaitDAO {
    //대기 확인을 위한 로그인
    WaitDTO waitLogin(WaitDTO wait);
    //기존 레코드 확인
    WaitDTO findByWaitTelAndState(String wait_tel);
    //대기 등록
    int waitInsert(WaitDTO wait);
    //대기 삭제
    int delete(String wait_no);
    //대기 리스트 확인
    List<WaitDTO> getWaitList();
    //대기상세조회 - db에 처리
    WaitDTO read(String wait_no);
    //wait_no로 세부정보 가져오기
    WaitDTO waitDetail(int wait_no);

}
