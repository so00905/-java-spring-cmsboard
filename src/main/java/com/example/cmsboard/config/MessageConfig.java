package com.example.cmsboard.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class MessageConfig {
    @Bean
    public MessageSource messageSource(){
        Locale.setDefault(Locale.KOREA); //메세지 인코딩 국가를 한국으로 설정
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setDefaultEncoding("UTF-8"); //인코딩설정
        messageSource.setBasenames("/message/security_message","classpath:org/springframework/security/messages");
        return messageSource;
    }
}
