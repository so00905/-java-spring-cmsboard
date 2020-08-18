package com.example.cmsboard.service;

//import com.example.cmsboard.dao.AccountRepository;
import com.example.cmsboard.vo.MasterVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface MasterService{

    String getBoard() ;
}
