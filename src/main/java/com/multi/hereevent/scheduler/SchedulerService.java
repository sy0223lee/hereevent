package com.multi.hereevent.scheduler;

import com.multi.hereevent.mail.MailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final MailService mailService;

    @Scheduled(cron = "0 0 9 ? * 1") // 매주 월요일 9시마다 실행
    public void sendRecommendEmail() throws MessagingException {
        mailService.sendRecommendEmail();
    }
}