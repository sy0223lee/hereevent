package com.multi.hereevent.wait;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.WaitDTO;

import java.util.List;

public interface WaitService {
    //대기 로그인
    WaitDTO waitLogin(WaitDTO wait);

    //대기 추가
    int waitInsert(WaitDTO wait);

    //대기리스트
    List<WaitDTO> getWaitList();

    //대기 상세 확인
    WaitDTO read(String wait_tel);

    //대기 상세정보 불러오기
    WaitDTO waitDetail(int wait_no);

    //대기 삭제
    int waitDelete(int wait_no);

    boolean canInsert(String wait_tel);
}
