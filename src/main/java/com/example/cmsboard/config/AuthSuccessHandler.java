package com.example.cmsboard.config;

import com.example.cmsboard.mapper.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    //    private RequestCache requestCache = new HttpSessionRequestCache();
//    private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
//
//    private String username;
//    private String defaultUrl;
//
//    @Autowired
//    AccountRepository accountRepository;
//
//    Logger log = LoggerFactory.getLogger(this.getClass());
//

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        System.out.println("Success!!!");
        HttpSession session = request.getSession();
        response.sendRedirect("/indexPage");
    }
}
//
//    protected void clearAuthenticationAttributes(HttpServletRequest request){
//        HttpSession session = request.getSession(false);
//        if(session==null) return;
//        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//    }
//
//    protected void resultRedirectStrategy(HttpServletRequest request,HttpServletResponse response,Authentication authentication)
//            throws IOException,ServletException{
//        SavedRequest savedRequest = requestCache.getRequest(request,response);
//        if(savedRequest != null) {
//
//            log.info("권한이 필요한 페이지에 접근하였다.");
//            useSessionUrl(request,response);
//
//        }else {
//
//            log.info("직접 로그인 url로 이동했을 경우!");
//            useDefaultUrl(request,response);
//        }
//    }
//    protected void useSessionUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        SavedRequest savedRequest = requestCache.getRequest(request, response);
//        String targetUrl = savedRequest.getRedirectUrl();
//        redirectStratgy.sendRedirect(request, response, targetUrl);
//    }
//    protected void useDefaultUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        redirectStratgy.sendRedirect(request, response, defaultUrl);
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getDefaultUrl() {
//        return defaultUrl;
//    }
//
//    public void setDefaultUrl(String defaultUrl) {
//        this.defaultUrl = defaultUrl;
//    }
//}

