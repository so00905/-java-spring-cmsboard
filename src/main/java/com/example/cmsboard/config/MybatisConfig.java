package com.example.cmsboard.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@MapperScan(value = {"com.example.cmsboard.mapper.MasterMapper"})
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource
            , ApplicationContext applicationContext) throws Exception {

        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);

        factory.setMapperLocations(applicationContext.getResources("classpath*:mybatis/mapper/*.xml"));
        factory.setTypeAliasesPackage("com.example.cmsboard.vo");

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
            configuration.setMapUnderscoreToCamelCase(true);
            configuration.setJdbcTypeForNull(null);

        factory.setConfiguration(configuration);

        return factory.getObject();
    }

}
