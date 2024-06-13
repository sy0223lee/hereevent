package com.multi.hereevent.crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class FindElementsFromElement {
    public static void main(String[] args) {
        // WebDriver 경로 설정
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");

        // WebDriver option 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://popply.co.kr/");

            // Get element with tag name 'div'
            WebElement element = driver.findElement(By.cssSelector("div.calendar-popup-list > ul > li:nth-child(1) > div > a:nth-child(2) > ul > li.popup-name"));

            // Get all the elements available with tag name 'p'
            List<WebElement> elements = element.findElements(By.tagName("p"));
            for (WebElement e : elements) {
                System.out.println(e.getText());
            }
        } finally {
            driver.quit();
        }
    }
}