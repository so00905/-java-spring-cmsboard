package com.example.cmsboard.mapper;
import com.example.cmsboard.vo.MasterVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface MasterMapper {

    MasterVO readAccount(String id);

    List<String> readAuthority(String id);

    //db연결 테스트용
    String getBoard();

    }

