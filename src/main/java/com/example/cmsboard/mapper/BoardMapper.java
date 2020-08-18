package com.example.cmsboard.mapper;

import com.example.cmsboard.vo.BoardVO;
import com.example.cmsboard.vo.SearchVO;
import com.example.cmsboard.vo.UserBoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardVO> selectBoard(SearchVO searchVO) throws Exception;

    List<BoardVO> selectTelCode() throws Exception;

    //게시글 총 갯수
    int countBoard(SearchVO searchVO) throws Exception;

    //공지사항 게시물 1개 조회
    BoardVO boardDetail(int bNo) ;

    //공지사항 조회수증가
    int UpdateHit(int bNo) throws Exception;

    //공지사항 등록
    void insertBoard(BoardVO boardVO) throws Exception;

    //사용자리스트
    List<UserBoardVO> selectUserBoard(SearchVO searchVO) throws Exception;

    //사용자리스트 게시글 총 갯수
    int countUserBoard(SearchVO searchVO) throws Exception;
}
