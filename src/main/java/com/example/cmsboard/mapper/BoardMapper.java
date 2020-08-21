package com.example.cmsboard.mapper;

import com.example.cmsboard.vo.BoardVO;
import com.example.cmsboard.vo.SearchVO;
import com.example.cmsboard.vo.UserBoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시글리스트
    List<BoardVO> selectBoard(SearchVO searchVO) throws Exception;

    //게시글쓰기에 통신사 select 박스리스트뿌리기
    List<BoardVO> selectTelCode() throws Exception;

    //게시글 총 갯수
    int countBoard(SearchVO searchVO) throws Exception;

    //공지사항 게시물 1개 조회
    BoardVO boardDetail(int bNo) ;

    //공지사항 조회수증가
    int UpdateHit(int bNo) throws Exception;

    //공지사항 등록
    void insertBoard(BoardVO boardVO) throws Exception;

    //게시글 수정
    void updateBoard(BoardVO boardVO) throws Exception;

    //게시글 삭제
    void deleteBoard(int bNo) throws Exception;







    //사용자리스트
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
