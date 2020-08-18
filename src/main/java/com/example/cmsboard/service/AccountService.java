package com.example.cmsboard.service;

import com.example.cmsboard.vo.BoardVO;
import com.example.cmsboard.vo.MasterVO;
import com.example.cmsboard.vo.SearchVO;
import com.example.cmsboard.vo.UserVO;

import java.util.List;

public interface AccountService {
    UserVO findById(String id) throws Exception;
}
