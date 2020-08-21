package com.example.cmsboard.controller;

import com.example.cmsboard.mapper.AccountRepository;
import com.example.cmsboard.service.AccountService;
import com.example.cmsboard.vo.MasterVO;
import com.example.cmsboard.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AccountService accountService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        try {
            System.out.println("여기는 authprovider 입니다.");
            String loginID = (String) authentication.getPrincipal();
            String loginPwd = (String) authentication.getCredentials();

            System.out.println("loginID" + loginID);
            System.out.println("loginPwd" + loginPwd);

            System.out.println("AuthProvider===================== loadUserByUserName 들어가는중");

            UserVO userVO = accountService.findById(loginID);
            if (userVO != null) {
                if (userVO.getAuthority().equals("ROLE_ADMIN")) {
                    ArrayList<GrantedAuthority> auth = new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));

                    if(passwordEncoder.matches(loginPwd, userVO.getPassword())){
                        System.out.println("비밀번호일치!");
                    }
                    else if (!passwordEncoder.matches(loginPwd, userVO.getPassword())) {
                        throw new BadCredentialsException("패스워드가 일치하지 않습니다.");
                    }
                    return new UsernamePasswordAuthenticationToken(userVO, null, auth);
                } else {
                    throw new BadCredentialsException(loginID);
                }


            } else {
                // 로그인 정보 없음
                throw new BadCredentialsException("존재하지 않는 아이디입니다.");
            }


            // password검사
//            if (!matchPassword(loginPwd, masterVO.getPassword())) {
//                log.debug("AuthProvider=====================비밀번호틀림");
//                throw new BadCredentialsException(loginID);
//            }


//            if(!masterVO.isEnabled() || !masterVO.isCredentialsNonExpired()){
//                log.debug("AuthProvider===================== isEnabled or isCredential false!!!!!");
//                throw new AuthenticationCredentialsNotFoundException(loginID);
//            }
//            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) masterVO.getAuthorities();
//
//            log.debug("AuthProvider=====================if문 위에!!");
//
//
//            //password검사
//            if (!matchPassword(loginPwd, masterVO.getPassword())) {
//                log.debug("AuthProvider=====================비밀번호틀림");
//                throw new BadCredentialsException(loginID);
//            }
//            log.debug("AuthProvider=====================비밀번호맞음");

//            return new UsernamePasswordAuthenticationToken(loginID, loginPwd, null);

        }catch (Exception e){
            e.printStackTrace();
            throw new BadCredentialsException(e.getMessage());
        }
    }


        // List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        //로그인한 계정에 권한을 부여한다.
//        if(masterVO.isEnabled()){
//            grantedAuthorityList.add(new SimpleGrantedAuthority(.ROLE_TYPE.ROLE_ADMIN.toString()));
//        }else {
//            System.out.println("프로바이저에러");
//        }
//        //로그인 성공시 사용자 정보를 반환한다.
//        return new MasterVO(username, password,grantedAuthorityList);
//
//        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return new UsernamePasswordAuthenticationToken(masterVO, null, grantedAuthorityList);
//    }
        //return new MasterVO(masterVO);

        @Override
        public boolean supports (Class < ? > authentication){
            return authentication.equals(UsernamePasswordAuthenticationToken.class);
        }

//        private boolean matchPassword(String loginPassword,String password){
//            log.debug("AuthProvider==================macthPassword 73Line");
//            return loginPassword.equals(password);
//        }

    }