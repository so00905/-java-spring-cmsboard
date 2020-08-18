package com.example.cmsboard.config;


import com.example.cmsboard.controller.AuthProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.example.cmsboard"})
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    AuthProvider authProvider;

    @Autowired
    AuthFailureHandler authFailureHandler;

    @Autowired
    AuthSuccessHandler authSuccessHandler;

    private Logger log = LoggerFactory.getLogger(this.getClass());



    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring()
                .antMatchers("/assets/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        System.out.println("여기는 security config 입니다.");
        http
                .authorizeRequests() // 해당 메소드 아래는 각 경로에 따른 권한을 지정할 수 있다.
                    .antMatchers("/login","/assets" , "/loginPage" , "/service" , "/resources/**" , "/create").permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
                    .antMatchers("/admin").hasRole("ADMIN") // 괄호의 권한을 가진 유저만 접근가능, ROLE_가 붙어서 적용 됨. 즉, 테이블에 ROLE_권한명 으로 저장해야 함.
                    .anyRequest().authenticated()  //  로그인된 사용자가 요청을 수행할 떄 필요하다  만약 사용자가 인증되지 않았다면, 스프링 시큐리티 필터는 요청을 잡아내고 사용자를 로그인 페이지로 리다이렉션 해준다.
                    .and()
                .formLogin() // 하위에 내가 직접 구현한 로그인 폼, 로그인 성공시 이동 경로 설정 가능. , 로그인 폼의 아이디,패스워드는 username, password로 맞춰야 함
                            .loginPage("/loginPage") // 로그인이 수행될 경로.
                            .loginProcessingUrl("/authenticate")// 로그인form의  action과 일치시켜주어야 함.
                            .failureUrl("/loginPage?error")
                            .failureHandler(authFailureHandler)
                            .successHandler(authSuccessHandler)
//                             .defaultSuccessUrl("/indexPage") // 로그인 성공 시 이동할 경로.
                             .usernameParameter("loginID")
                            .passwordParameter("loginPwd")
                            .permitAll()
                    .and()
                        .logout()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/loginPage")
                        .invalidateHttpSession(true)
                    .and()
                        .csrf()
                    .and()
                        .authenticationProvider(authProvider);
//                        .exceptionHandling()
//                        .accessDeniedPage("/accessDenied_page"); //권한이 없는 자가 접속할 시 보여질 화면

    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        log.info("[ BEAN ] : passwordEncoder");
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }





}
