package com.example.cmsboard.mapper;

import com.example.cmsboard.vo.MasterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {

    @Autowired
    MasterMapper masterMapper;

    public MasterVO findById(String username) {
        return masterMapper.readAccount(username);
    }

    public List<String> findAuthority(String username){
        return  masterMapper.readAuthority(username);
    }
}

