package com.example.cmsboard.service.Impl;

import com.example.cmsboard.mapper.BoardMapper;
import com.example.cmsboard.service.BoardService;
import com.example.cmsboard.vo.BoardVO;
import com.example.cmsboard.vo.SearchVO;
import com.example.cmsboard.vo.UserBoardVO;
import com.fasterxml.jackson.annotation.JacksonInject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @JacksonInject
    private SqlSession session;

    @Override
    public List<BoardVO> selectBoard(SearchVO searchVO) throws Exception{
        List<BoardVO> listBoard = boardMapper.selectBoard(searchVO);
        return listBoard;
    }

    @Override
    public List<BoardVO> selectTelCode() throws Exception{
        List<BoardVO> telcode = boardMapper.selectTelCode();
        return telcode;
    };


    //게시글 총 갯수
    @Override
    public int countBoard(SearchVO searchVO) throws Exception{
        return boardMapper.countBoard(searchVO);
    }

    //공지사항 게시물 1개 조회
    @Override
    public BoardVO boardDetail(int bNo) {
        System.out.println("sysout service여기"+ boardMapper.boardDetail(bNo));
        return boardMapper.boardDetail(bNo);
    }

    //공지사항 등록
    @Override
    public void insertBoard(BoardVO boardVO) throws Exception{
        System.out.println("insertBoard serviceImpl");
        String boardTitle = boardVO.getbTitle();
        String TelCode = boardVO.getTelName();
        String boardContent = boardVO.getbContent();

        boardVO.setbTitle(boardTitle);
        boardVO.setTelName(TelCode);
        boardVO.setbContent(boardContent);
        boardMapper.insertBoard(boardVO);

    }

    //공지사항 조회수증가
    @Override
    public void UpdateHit(int bNo) throws Exception{
        boardMapper.UpdateHit(bNo);
    }

    //게시글 수정
    @Override
    public void updateBoard(BoardVO boardVO) throws Exception{
        System.out.println("boardVO : " + boardVO.getTelName());
        boardMapper.updateBoard(boardVO);
    };


    //게시글 삭제
    @Override
    public void deleteBoard(int bNo) throws Exception{
        boardMapper.deleteBoard(bNo);
    };





//================================================================================================================================

    //사용자리스트
    @Override
    public List<UserBoardVO> selectUserBoard(SearchVO searchVO) throws Exception{
        List<UserBoardVO> UserListBoard = boardMapper.selectUserBoard(searchVO);
        return UserListBoard;
    }

    //사용자리스트 게시글 총 갯수
    @Override
    public int countUserBoard(SearchVO searchVO) throws Exception{
        return boardMapper.countUserBoard(searchVO);
    }

    //사용자 등록
    @Override
    public void insertUser(UserBoardVO userBoardVO) throws Exception{
        System.out.println("insertBoard serviceImpl");
        String userID = userBoardVO.getcId();
        String userName = userBoardVO.getcName();
        String userPwd = userBoardVO.getcPwd();
        String userPhone = userBoardVO.getcPhone();
        String userTel = userBoardVO.getTelName();

        userBoardVO.setcId(userID);
        userBoardVO.setcName(userName);
        userBoardVO.setcPwd(userPwd);
        userBoardVO.setcPhone(userPhone);
        userBoardVO.setTelName(userTel);

        boardMapper.insertUser(userBoardVO);

    };

    //사용자정보 1개 조회
    @Override
    public UserBoardVO UserDetail(int cNo) throws Exception{
        System.out.println("sysout service여기"+ boardMapper.UserDetail(cNo));
        return boardMapper.UserDetail(cNo);
    };

    //사용자 정보수정
    @Override
    public void updateUser(UserBoardVO userBoardVO) throws Exception{
        System.out.println("userBoardVO : " + userBoardVO.getTelName());
        boardMapper.updateUser(userBoardVO);
    };

    //사용자 정보삭제
    @Override
    public void deleteUser(int cNo) throws Exception{
        boardMapper.deleteUser(cNo);
    };
}
