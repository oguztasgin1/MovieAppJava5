package com.oguztasgin.MovieAppJava5.mvccontroller;

import com.oguztasgin.MovieAppJava5.dto.request.UserRegisterRequestDto;
import com.oguztasgin.MovieAppJava5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mvcr")
@RequiredArgsConstructor
public class UserMvcController {
    private final UserService userService;


    @GetMapping("/mvcregister")
    public ModelAndView register(){
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        return model;
    }

    @PostMapping("/mvcregister")
    public ModelAndView register(UserRegisterRequestDto dto){
        ModelAndView model = new ModelAndView();
        userService.register2(dto);
        return model;
    }
}
