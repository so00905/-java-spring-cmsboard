package com.example.cmsboard;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CmsboardApplicationTests {

    @Autowired
    private SqlSessionFactory sqlSession;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSqlSession() throws Exception{
        System.out.println("sqlSession : " + sqlSession);
    }

}
