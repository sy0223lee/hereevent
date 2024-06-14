package com.multi.hereevent.member;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigInteger;
import java.security.SecureRandom;

@Controller
public class NaverLoginController {
    @GetMapping("/login/naver")
    public String naverConnect(){
        // state용 난수 생성
        SecureRandom random = new SecureRandom();
        String state = new BigInteger(130, random).toString(32);

        // 네이버 로그인 인증 요청문 생성
        String url = "https://nid.naver.com/oauth2.0/authorize?client_id=" + "08J45Bf5olDzizmNsIcJ" +
                    "&response_type=code&redirect_uri=" + "http://localhost:9090/hereevnet/login/naver/callback" +
                    "&state=" + state;

        System.out.println("===== 네이버 로그인 인증 요청 =====");
        return "redirect:" + url;
    }

    @RequestMapping(value = "/login/naver/callback",
            method = {RequestMethod.GET, RequestMethod.POST},
            produces = "application/json")
    public void naverLogin(@RequestParam("code") String code, @RequestParam("state") String state){
        // 여기로 안 넘어와....
        System.out.println("===== 네이버 로그인 접근 토큰 요청 =====");
        // 접근 토큰 요청문 생성
        String url = "https://nid.naver.com/oauth2.0/token" +
                "?client_id=" + "08J45Bf5olDzizmNsIcJ" +
                "&client_secret=" + "53JS4ixZ2M" +
                "&grant_type=authorization_code" +
                "&state=" + "state" +
                "&code=" + "code";

        // POST 요청 보내고 응답 JSON 객체로 저장
        WebClient client = WebClient.create(url);
        JSONObject response = client.post()
                                    .retrieve().bodyToMono(JSONObject.class).block();
        System.out.println("===== 네이버 로그인 접근 토큰 응답 =====");
        // JSON 에서 접근 토큰 추출
        String token = response.getString("access_token");
        System.out.println("===== 네이버 로그인 사용자 정보 요청 =====");
        getUserInfo(token);
    }

    public void getUserInfo(String accessToken){
        // 사용자 정보 요청
        WebClient client = WebClient.create("https://openapi.naver.com/v1/nid/me");
        JSONObject response = client.get()
                                    .header("Authorization", "Bearer " + accessToken)
                                    .retrieve().bodyToMono(JSONObject.class).block();

        System.out.println("[사용자 정보] " + response);
    }
}
