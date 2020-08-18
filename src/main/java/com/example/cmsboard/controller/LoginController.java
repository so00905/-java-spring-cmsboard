package com.example.cmsboard.controller;

import com.example.cmsboard.vo.MasterVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/loginPage?error")
    public String login(@RequestParam(value = "error",required = false)String error
                        ,@ModelAttribute("loginPage")MasterVO masterVO
                        , Model model){
        System.out.println("로그인에러처리");
        if(error != null) {
            model.addAttribute("errorMsg", "Invalid username and password");
        }
        return "loginPage";
    }

}
