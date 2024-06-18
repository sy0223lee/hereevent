package com.multi.hereevent.member;

import com.multi.hereevent.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.security.SecureRandom;

@Controller
@RequiredArgsConstructor
public class NaverLoginController {
    private final MemberService service;

    @GetMapping("/login/naver")
    public String naverConnect(){
        // state 용 난수 생성
        SecureRandom random = new SecureRandom();
        String state = new BigInteger(130, random).toString(32);

        // 네이버 로그인 인증 요청문 생성
        String url = "https://nid.naver.com/oauth2.0/authorize?client_id=" + "08J45Bf5olDzizmNsIcJ" +
                    "&response_type=code&redirect_uri=http://localhost:9090/hereevent/login/naver/callback" +
                    "&state=" + state;

        System.out.println("===== 네이버 로그인 인증 요청 =====");
        return "redirect:" + url;
    }

    @GetMapping("/login/naver/callback")
    public String naverLogin(@RequestParam("code") String code, @RequestParam("state") String state) throws ParseException {
        System.out.println("===== 네이버 로그인 접근 토큰 요청 =====");
        String url = "https://nid.naver.com/oauth2.0/token";
        RestTemplate restTemplate = new RestTemplate();

        // HttpHeader Object
        HttpHeaders headers = new HttpHeaders();
        // HttpBody Object
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "08J45Bf5olDzizmNsIcJ");
        params.add("client_secret", "53JS4ixZ2M");
        params.add("code", code);
        params.add("state", state);
        // Http Header 와 Http Body params 를 가진 엔티티
        HttpEntity<MultiValueMap<String, String>> naverTokenRequest = new HttpEntity<>(params, headers);

        // url 로 Http 요청, POST 방식
        ResponseEntity<String> response = restTemplate.exchange(url,
                HttpMethod.POST, naverTokenRequest, String.class);

        // 출력
        String responseBody = response.getBody();
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(responseBody);
        String accessToken = (String) object.get("access_token");
        System.out.println("[accessToken]: " + accessToken);

        getUserInfo(accessToken);


        return "redirect:/";
    }

    public void getUserInfo(String accessToken) throws ParseException {
        String url = "https://openapi.naver.com/v1/nid/me";
        RestTemplate restTemplate = new RestTemplate();

        // HttpHeader Object
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        // Http Header 와 Http Body params 를 가진 엔티티
        HttpEntity<MultiValueMap<String, String>> naverInfoRequest = new HttpEntity<>(headers);

        // url 로 Http 요청, POST 방식
        ResponseEntity<String> response = restTemplate.exchange(url,
                HttpMethod.POST, naverInfoRequest, String.class);

        // 출력
        String responseBody = response.getBody();
        System.out.println(responseBody);
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(responseBody);

        // {"id":"FSZPR2GWa_330BHMOma5NTLlo42jTLedEfkUgAOhia4","nickname":"sy0****","email":"email@naver.com","mobile":"010-1234-1234","mobile_e164":"+821012341234","name":"\uc774\uc2b9\uc724"}
        String email = (String) object.get("email");
        String pass = (String) object.get("naver"); // 소셜 로그인의 경우 패스워드를 따로 저장하지 않으므로 어느 사이트 로그인인지 저장
        String name = (String) object.get("name");
        String nick = (String) object.get("nickname");
        String tel = (String) object.get("mobile");

        MemberDTO member = service.memberFindByEmail(email);
        if(member != null){
            System.out.println("회원 정보 조회");
        }else{
            System.out.println("회원 정보 없으므로 insert 필요");
        }
    }
}
