package projectmofit.mofit.domain.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projectmofit.mofit.domain.user.service.KakaoLoginService;

import java.util.HashMap;


@Controller
@RequestMapping("/kakao")
public class KakaoController {
    @Autowired
    public KakaoLoginService kakaoLoginServie;

    // 1번 카카오톡에 사용자 코드 받기(jsp의 a태그 href에 경로 있음)
    // 2번 받은 code를 iKakaoS.getAccessToken로 보냄 ###access_Token###로 찍어서 잘 나오면은 다음단계진행
    // 3번 받은 access_Token를 iKakaoS.getUserInfo로 보냄 userInfo받아옴, userInfo에 nickname, email정보가 담겨있음
    @GetMapping("/login")
    public String kakaoLogin(@RequestParam(value = "code", required = false) String code, Model model)throws Throwable{
            // 1번
            System.out.println("code:" + code);

            // 2번
            String access_Token = kakaoLoginServie.getAccessToken(code);
            System.out.println("###access_Token#### : " + access_Token);
            // 위의 access_Token 받는 걸 확인한 후에 밑에 진행

            // 3번
            HashMap<String, Object> userInfo = kakaoLoginServie.getUserInfo(access_Token);
            System.out.println("###nickname#### : " + userInfo.get("nickname"));
            System.out.println("###email#### : " + userInfo.get("email"));
            System.out.println(userInfo);
            model.addAttribute("userInfo",userInfo);

        return "kakao/result";
    }
}
