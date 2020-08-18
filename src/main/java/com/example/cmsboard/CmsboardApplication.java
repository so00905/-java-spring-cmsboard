package com.example.cmsboard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import javax.management.MXBean;


//@SpringBootApplication은 @Configuration, @EnableAutoConfiguration, @ComponentScan
// 어노테이션이 합쳐진 것으로써 스프링부트 기반의 애플리케이션이다.
@SpringBootApplication
public class CmsboardApplication implements WebMvcConfigurer {


    public static void main(String[] args) {

        SpringApplication.run(CmsboardApplication.class, args);
        System.out.println("Spring Boot Started.");
    }

    //view resolver 설정->> 없어도 돌아가길래 일단 주석처리
//    @Bean
//    public InternalResourceViewResolver setupViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("리소스경로");
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("/assets/");
    }

}
