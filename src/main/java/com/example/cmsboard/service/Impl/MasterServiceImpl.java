package com.example.cmsboard.service.Impl;

import com.example.cmsboard.mapper.MasterMapper;
import com.example.cmsboard.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterMapper masterMapper;

//@Autowired 생성자방식
//    @Autowired
//    MasterServiceImpl(MasterMapper mapper){
//        this.mapper = mapper;
//    }

    public String getBoard(){
        System.out.println("service in");
        String testSysDate = masterMapper.getBoard();
        System.out.println("DAO out");
        return testSysDate;
    }




//    @Override
//    public MasterVO selectInfo()throws Exception{
//        return masterDao.selectInfo();
//    };
}
