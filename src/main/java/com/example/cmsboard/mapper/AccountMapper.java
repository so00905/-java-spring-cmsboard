package com.example.cmsboard.mapper;
import com.example.cmsboard.vo.MasterVO;
import com.example.cmsboard.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    UserVO readAccount(String id) throws Exception;

    List<String> readAuthority(String id);
}

