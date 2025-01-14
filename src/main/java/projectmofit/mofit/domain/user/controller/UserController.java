package projectmofit.mofit.domain.user.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projectmofit.mofit.domain.user.dto.User;
import projectmofit.mofit.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signUpForm(@ModelAttribute User user) {
        return "user/signUpForm";
    }

    // 회원가입
    // TODO 이메일 인증, 닉네임 중복 확인
    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/signUpForm";
        }

        userService.signUp(user);
        return "redirect:/";
    }

    // TODO login, logout, 프로필 사진 수정

    // Do or Not? 회원 정보 수정, 비밀번호 찾기, 탈퇴하기
}
