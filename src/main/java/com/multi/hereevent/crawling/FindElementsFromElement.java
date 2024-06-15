package com.multi.hereevent.crawling;

import com.multi.hereevent.dto.EventDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindElementsFromElement {
    public static void main(String[] args) {
        // WebDriver 경로 설정
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

        // WebDriver option 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking"); // 팝업창 무시

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        List<EventDTO> eventList = new ArrayList<>(); // 이벤트 정보 저장할 리스트
        List<String> eventDetailList = new ArrayList<>(); // 이벤트 상세 정보 url 저장할 리스트
        try {
            driver.get("https://popply.co.kr/popup?area=all&startDate=2024-06-15&endDate=2024-06-15&status=open");

            WebElement element = driver.findElement(By.cssSelector("div.calendar-popup-list.popuplist-board"));

            // 팝업 이미지, 상세 정보 리스트에 저장
            List<WebElement> elements = element.findElements(By.className("popup-img-wrap"));
            for (WebElement e : elements) {
                EventDTO event = new EventDTO();
                event.setImg_path(e.findElement(By.tagName("img")).getAttribute("src")); // 이미지 URL

                eventList.add(event); // 이미지 경로를 포함한 이벤트 DTO 저장
                eventDetailList.add(e.getAttribute("href")); // 상세 페이지 경로 저장
            }

            int len = eventList.size();
            for(int i=0; i<len; i++) {
                String detailUrl = eventDetailList.get(i);
                driver.get(detailUrl);
                element = driver.findElement(By.cssSelector(".popupdetail-wrap"));

                /* EventDTO */
                EventDTO event = eventList.get(i);
                System.out.println(getEvent(element, detailUrl, event));
                // insert event
                // select event_no from event where name = #{name}

                /* EventRuntimeDTO */
                String event_no; // select event 한 결과값
                String day; // 월, 화, 수, 목, 금, 토, 일
                Time openTime; // 시작 시간
                Time closeTime; // 종료 시간
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    // 이벤트 정보 EventDTO 에 저장
    private static EventDTO getEvent(WebElement element, String detailUrl, EventDTO event) throws ParseException {
        String name = element.findElement(By.cssSelector("h1.tit")).getText(); // 이벤트 이름
        String addr = element.findElement(By.cssSelector("p.location")).getText(); // 위치
        String info = element.findElement(By.cssSelector(".popupdetail-info-inner")).getText(); // 이벤트 소개

        String date = element.findElement(By.cssSelector("p.date")).getText(); // 이벤트 운영 기간
        Date startDate = new SimpleDateFormat("yy.MM.dd").parse(date.substring(0,8)); // 시작일자
        Date endDate = new SimpleDateFormat("yy.MM.dd").parse(date.substring(11)); // 종료일자

        // 링크 크롤링 불가... 자기네 DB에 따로 저장해서 변수로 불러오는 방식이라 링크가 노출되어 있지 않는 것 같음...!
        String homepage = null; // 브랜드 홈페이지
        String sns = null; // 브랜드 SNS
        List<WebElement> linkList = element.findElements(By.cssSelector(".popupdetail-link > ul > li"));
        for (WebElement e : linkList) {
            try { // 링크가 없는 경우 넘어갈 수 있도록 try-catch 문 사용
                String type = e.findElement(By.tagName("a")).getText();
                String link = e.findElement(By.tagName("a")).getAttribute("href");
                System.out.println("[type : link] " + type + " : " + link);
                if (type.equals("브랜드 홈페이지 바로가기") && !link.equals(detailUrl)) {
                    homepage = link;
                } else if (type.equals("SNS 바로가기") && !link.equals(detailUrl)) {
                    sns = link;
                }
            } catch (Exception ignored) {

            }
        }
        event.setName(name);
        event.setStart_date(new java.sql.Date(startDate.getTime())); // util.Date 를 sql.Date 로 변환
        event.setEnd_date(new java.sql.Date(endDate.getTime()));
        event.setAddr(addr);
        event.setInfo(info);
        event.setHomepage(homepage);
        event.setSns(sns);
        return event;
    }
}