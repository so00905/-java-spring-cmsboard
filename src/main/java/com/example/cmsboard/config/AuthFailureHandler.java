package com.example.cmsboard.config;

import com.example.cmsboard.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {

//    @Resource
//    AccountService accountService;
//
//    private String username;
//    private String password;
//
//    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        System.out.println("######### onAuthenticationFailure #########");
        response.sendRedirect("/loginPage");

//        log.info("######### onAuthenticationFailure #########");
//        String loginId = request.getParameter(username);
//        String loginPwd = request.getParameter(password);
//response.sendRedirect("/indexPage");
        //response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // 실패 시 response를 json 형태로 결과값 전달
//        response.getWriter().print("{\"success\": false}");
//        response.getWriter().flush();
    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}