package com.example.cmsboard.controller;

//import com.example.cmsboard.service.AccountService;
import com.example.cmsboard.mapper.MasterMapper;
import com.example.cmsboard.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class MasterController {

    @Autowired
    private MasterService masterService;

    @Autowired
    MasterMapper masterMapper;

    @RequestMapping("board")
    public String now(Model model) {
        System.out.println("현재시간을 가져오나 테스트1번 : " + masterService.getBoard());
        model.addAttribute("now",masterService.getBoard());
        System.out.println("현재시간을 가져오나 테스트2번 : " + masterService.getBoard());

        return "indexPage";
    }

    // LOGIN
//    @RequestMapping("/loginPage")
//    public String loginPageTest(){
//        System.out.println("indexPage 컨트롤러에 들어왔음");
//        return "loginPage";
//    }

    @RequestMapping("/loginPage")
    public ModelAndView loginPageTest(HttpServletRequest request, HttpServletResponse response){
        System.out.println("username");
        System.out.println("password");

        ModelAndView model = new ModelAndView();
        System.out.println("여기까지나오나");

        model.setViewName("loginPage");
        return model;
    }

    // LOGIN SUCCESS  
    @RequestMapping("/loginSuccess")
    public String loginSuccess() {
        return "adminPage";
    }


    @RequestMapping("/userList")
    public String user() {
        System.out.println("유저리스트컨트롤러들어옴");
        return "userTable"; //권한이 맞으면 페이지로 이동.
    }
    //==========================security



    @RequestMapping("/accessDenied_page")
    public String accessDenied() {
        return "accessDenied_page";
    }


    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }

}
