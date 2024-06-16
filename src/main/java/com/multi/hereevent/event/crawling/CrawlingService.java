package com.multi.hereevent.event.crawling;

import com.multi.hereevent.dto.EventDTO;
import com.multi.hereevent.dto.EventTimeDTO;
import com.multi.hereevent.event.EventService;
import com.multi.hereevent.event.time.EventTimeService;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CrawlingService {
    private final EventService eventService;
    private final EventTimeService eventTimeService;

    public void insertEventInfo() {
        // WebDriver 경로 설정
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

        // WebDriver option 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking"); // 팝업창 무시

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        List<EventDTO> eventList = new ArrayList<>(); // 이벤트 정보 저장할 리스트
        List<String> eventDetailList = new ArrayList<>(); // 이벤트 상세 정보 url 저장할 리스트

        // URL 에 넣을 date 계산
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        Calendar cal = Calendar.getInstance(Locale.KOREA);
        cal.add(Calendar.DATE, 14);
        String day = sdf.format(cal.getTime());
        try {
            driver.get("https://popply.co.kr/popup?area=all&startDate=" + day + "&endDate=" + today + "&status=open");

            WebElement element = driver.findElement(By.cssSelector("div.calendar-popup-list.popuplist-board"));

            // 팝업 이미지, 상세 정보 리스트에 저장
            List<WebElement> elements = element.findElements(By.className("popup-img-wrap"));
            for (WebElement e : elements) {
                EventDTO event = new EventDTO();
//                event.setImg_path(e.findElement(By.tagName("img")).getAttribute("src")); // 이미지 URL

                eventList.add(event); // 이미지 경로를 포함한 이벤트 DTO 저장
                eventDetailList.add(e.getAttribute("href")); // 상세 페이지 경로 저장
            }

            int len = eventList.size();
            for(int i=0; i<len; i++) {
                String detailUrl = eventDetailList.get(i);
                driver.get(detailUrl);

                element = driver.findElement(By.cssSelector(".popupdetail-wrap"));
                EventDTO event = eventList.get(i);

                // 이벤트 정보 가져오기
                String name = element.findElement(By.cssSelector("h1.tit")).getText(); // 이벤트 이름
                String addr = element.findElement(By.cssSelector("p.location")).getText(); // 위치
                String info = element.findElement(By.cssSelector(".popupdetail-info-inner")).getText(); // 이벤트 소개

                String[] date = element.findElement(By.cssSelector("p.date")).getText().split(" - "); // 이벤트 운영 기간
                Date startDate = new SimpleDateFormat("yy.MM.dd").parse(date[0]); // 시작일자
                Date endDate = new SimpleDateFormat("yy.MM.dd").parse(date[1]); // 종료일자

                // 링크 크롤링 불가... 자기네 DB에 따로 저장해서 변수로 불러오는 방식이라 링크가 노출되어 있지 않는 것 같음...!
                String homepage = null; // 브랜드 홈페이지
                String sns = null; // 브랜드 SNS
                List<WebElement> linkList = element.findElements(By.cssSelector(".popupdetail-link > ul > li"));
                for (WebElement e : linkList) {
                    try { // 링크가 없는 경우 에러로 멈추지 않고 넘어갈 수 있도록 try-catch 문 사용
                        String type = e.findElement(By.tagName("a")).getText();
                        String link = e.findElement(By.tagName("a")).getAttribute("href");
                        if (type.equals("브랜드 홈페이지 바로가기") && !link.equals(detailUrl)) {
                            homepage = link;
                        } else if (type.equals("SNS 바로가기") && !link.equals(detailUrl)) {
                            sns = link;
                        }
                    } catch (Exception ignored) {

                    }
                }
                // EventDTO 에 가져온 정보 set
                event.setName(name);
                event.setStart_date(new java.sql.Date(startDate.getTime())); // util.Date 를 sql.Date 로 변환
                event.setEnd_date(new java.sql.Date(endDate.getTime()));
                event.setAddr(addr);
                event.setInfo(info);
                event.setHomepage(homepage);
                event.setSns(sns);

                // 이벤트 이름, 기간이 동일한 이벤트가 이미 존재하는 경우 삽입 X, 존재하지 않는 경우 삽입
                // 새로운 이벤트가 삽입된 경우 이벤트 운영 시간도 삽입
                if(eventService.insertCrawlingEvent(event) > 0) {
                    List<EventTimeDTO> eventTimeList = new ArrayList<>();

                    element = driver.findElement(By.cssSelector("ul.open"));
                    int eventNo = eventService.selectEventNoByEventName(name); // select event 한 결과값

                    List<WebElement> timeList = element.findElements(By.tagName("li"));
                    for(WebElement e : timeList){
                        String text = e.getText();
                        if(text.isEmpty()) { // li 태그에 텍스트가 없는 경우 continue
                            continue;
                        }

                        String[] dayTime = text.split(" : ");
                        if(dayTime[1].equals("휴뮤")){
                            eventTimeList.add(new EventTimeDTO(eventNo, dayTime[0], null, null));
                        }else{
                            String[] times = dayTime[1].split(" ~ ");
                            eventTimeList.add(new EventTimeDTO(eventNo, dayTime[0], times[0], times[1]));
                        }
                    }

                    eventTimeService.insertEventTimeList(eventTimeList);
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}