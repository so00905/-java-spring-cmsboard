package com.example.cmsboard.service;

import com.example.cmsboard.vo.BoardVO;
import com.example.cmsboard.vo.SearchVO;
import com.example.cmsboard.vo.UserBoardVO;

import java.util.List;

public interface BoardService {

    //공지사항페이지 select
    List<BoardVO> selectBoard(SearchVO searchVO) throws Exception;

    List<BoardVO> selectTelCode() throws Exception;

    //게시글 총 갯수
    int countBoard(SearchVO searchVO) throws Exception;

    //공지사항 게시물 1개 조회
    BoardVO boardDetail(int bNo) ;

    //공지사항 등록
    void insertBoard(BoardVO boardVO) throws Exception;
//
    //공지사항 조회수증가
    void UpdateHit(int bNo) throws Exception;

    //게시글 수정
    void updateBoard(BoardVO boardVO) throws Exception;

    //게시글 삭제
    void deleteBoard(int bNo) throws Exception;


//============사용자===========================================



    //사용자리스트페이지 select
    List<UserBoardVO> selectUserBoard(SearchVO searchVO) throws Exception;

    //사용자리스트 게시글 총 갯수
    int countUserBoard(SearchVO searchVO) throws Exception;

    //사용자 등록
    void insertUser(UserBoardVO userBoardVO) throws Exception;

    //사용자정보 1개 조회
    UserBoardVO UserDetail(int cNo) throws Exception;

    //사용자 정보수정
    void updateUser(UserBoardVO userBoardVO) throws Exception;

    //사용자 정보삭제
    void deleteUser(int cNo) throws Exception;
}
