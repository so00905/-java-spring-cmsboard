package com.example.cmsboard.service.Impl;

import com.example.cmsboard.mapper.AccountMapper;
import com.example.cmsboard.mapper.MasterMapper;
import com.example.cmsboard.service.AccountService;
import com.example.cmsboard.service.MasterService;
import com.example.cmsboard.vo.MasterVO;
import com.example.cmsboard.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public UserVO findById(String id) throws Exception {
        return accountMapper.readAccount(id);
    }
}
