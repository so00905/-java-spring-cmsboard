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


//    //게시글 총 갯수
    @Override
    public int countBoard(SearchVO searchVO) throws Exception{
        return boardMapper.countBoard(searchVO);
    }
//
    //공지사항 게시물 1개 조회
    @Override
    public BoardVO boardDetail(int bNo) {
        System.out.println("sysout service여기"+ boardMapper.boardDetail(bNo));
        return boardMapper.boardDetail(bNo);
    }
//
    //공지사항 등록
    @Override
    public void insertBoard(BoardVO boardVO) throws Exception{
        String boardTitle = boardVO.getbTitle();
        String TelCode = boardVO.getTelName();
        String boardContent = boardVO.getbContent();

        boardVO.setbTitle(boardTitle);
        boardVO.setTelName(TelCode);
        boardVO.setbContent(boardContent);
        boardMapper.insertBoard(boardVO);

    }
//
    //공지사항 조회수증가
    @Override
    public void UpdateHit(int bNo) throws Exception{
        boardMapper.UpdateHit(bNo);
    }

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
}
