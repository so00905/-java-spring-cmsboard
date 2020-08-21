package com.example.cmsboard.controller;

import com.example.cmsboard.mapper.BoardMapper;
import com.example.cmsboard.mapper.MasterMapper;
import com.example.cmsboard.service.BoardService;
import com.example.cmsboard.service.MasterService;
import com.example.cmsboard.vo.BoardVO;
import com.example.cmsboard.vo.SearchVO;
import com.example.cmsboard.vo.UserBoardVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    BoardMapper boardMapper;

    //공지사항목록띄우기
    @RequestMapping(value = "indexPage", method = RequestMethod.GET)
    public String noticeboard(SearchVO searchVO, Model model
            ,@RequestParam(value="nowPage", required=false)String nowPage
            ,@RequestParam(value="cntPerPage", required=false)String cntPerPage
            ,@RequestParam(required = false)String selectTel
            ,@RequestParam(required = false)String selectType
            ,@RequestParam(required = false)String keyword) throws Exception {

        System.out.println("boardcontroller indexPage 컨트롤러에 들어왔음");

        searchVO.setSelectTel(selectTel);
        searchVO.setSelectType(selectType);
        searchVO.setKeyword(keyword);

        int total = boardService.countBoard(searchVO);

        if (nowPage == null && cntPerPage == null) {
            nowPage = "1";
            cntPerPage = "5";
        } else if (nowPage == null) {
            nowPage = "1";
        } else if (cntPerPage == null) {
            cntPerPage = "5";
        }

        searchVO = new SearchVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

        searchVO.setSelectTel(selectTel);
        searchVO.setSelectType(selectType);
        searchVO.setKeyword(keyword);

        List<BoardVO> selectBoard = boardService.selectBoard(searchVO);
        model.addAttribute("board",selectBoard);
        //model.addAttribute("paging",SearchVO);
//        for(int i=0 ; i<selectBoard.size() ; i++) {
//            System.out.println("DB connect" + selectBoard.get(i));
//        }
        List<BoardVO> telcode = boardService.selectTelCode();
        model.addAttribute("selectTelCode",telcode);
        System.out.println("sysout컨트롤러는 여기!!" + telcode);

        model.addAttribute("paging",searchVO);

        return "indexPage";
    }

    //게시글등록페이지 이동
    @RequestMapping("/boardWrite")
    public String boardWrite(Model model,BoardVO boardVO) throws Exception {
        List<BoardVO> telcode = boardService.selectTelCode();
        model.addAttribute("selectTelCode",telcode);
        System.out.println("sysout컨트롤러는 여기!!" + telcode);
        return "boardWrite";
    }

    //상세보기화면
    @RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
    public String boardDetail(
            Model model
            , @RequestParam("bNo") int bNo) throws Exception {
        boardService.UpdateHit(bNo);
        BoardVO BoardTelCode = boardService.boardDetail(bNo);
        System.out.println(BoardTelCode);

        List<BoardVO> telcode = boardService.selectTelCode();
        model.addAttribute("selectTelCode",telcode);
        model.addAttribute("boardDetail",BoardTelCode);
        model.addAttribute("bNo",bNo);
        return "boardDetail";
    }

    //글작성등록 컨트롤러
    @RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
    public String insertBoard(BoardVO boardVO) throws Exception{
        System.out.println("ddddd");
        System.out.println("인서트보드" + boardVO.getbTitle());
        boardService.insertBoard(boardVO);
     return "redirect:indexPage";
    }

    //글수정컨트롤러
    @RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
    public String updateBoard(@ModelAttribute BoardVO boardVO) throws Exception{

        System.out.println("fffff");
        System.out.println("업데이트보드에 들어옴 제목은 : " + boardVO.getbTitle());
        System.out.println("boardVO : " + boardVO);
        //System.out.println("content" + boardVO.getbContent()); run
        //System.out.println("telname" + boardVO.getTelName());
        try {
            boardService.updateBoard(boardVO);

        }catch (Exception e){
            return e.getMessage();
        }
        return "redirect:indexPage";
    }

    //글 삭제 컨트롤러
    @RequestMapping(value = "/boardDelete")
    public String deleteBoard(@RequestParam int bNo) throws Exception{
        boardService.deleteBoard(bNo);
        return "redirect:indexPage";
    }






//=============================================사용자

    //사용자리스트띄우기
    @RequestMapping(value = "userListPage", method = RequestMethod.GET)
    public String UserBoard(SearchVO searchVO, Model model
            ,@RequestParam(value="nowPage", required=false)String nowPage
            ,@RequestParam(value="cntPerPage", required=false)String cntPerPage
            ,@RequestParam(required = false)String selectTel
            ,@RequestParam(required = false)String selectType
            ,@RequestParam(required = false)String keyword) throws Exception {

        System.out.println("boardcontroller userList 컨트롤러에 들어왔음");

        searchVO.setSelectTel(selectTel);
        searchVO.setSelectType(selectType);
        searchVO.setKeyword(keyword);

        int total = boardService.countUserBoard(searchVO);

        if (nowPage == null && cntPerPage == null) {
            nowPage = "1";
            cntPerPage = "5";
        } else if (nowPage == null) {
            nowPage = "1";
        } else if (cntPerPage == null) {
            cntPerPage = "5";
        }

        searchVO = new SearchVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

        searchVO.setSelectTel(selectTel);
        searchVO.setSelectType(selectType);
        searchVO.setKeyword(keyword);

        List<UserBoardVO> selectUserBoard = boardService.selectUserBoard(searchVO);
        model.addAttribute("UserBoard",selectUserBoard);
        //model.addAttribute("paging",SearchVO);
//        for(int i=0 ; i<selectBoard.size() ; i++) {
//            System.out.println("DB connect" + selectBoard.get(i));
//        }

        List<BoardVO> telcode = boardService.selectTelCode();
        model.addAttribute("selectTelCode",telcode);
        System.out.println("sysout컨트롤러는 여기!!" + telcode);

        model.addAttribute("paging",searchVO);

        return "userTable";
    }



    //사용자등록페이지 이동
    @RequestMapping("/UserReg")
    public String UserWrite(Model model,UserBoardVO userBoardVO) throws Exception {
        List<BoardVO> telcode = boardService.selectTelCode();
        model.addAttribute("selectTelCode",telcode);
        System.out.println("sysout컨트롤러는 여기!!" + telcode);
        return "UserReg";
    }

    //사용자등록하기
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public String insertUser(UserBoardVO userBoardVO) throws Exception{
        System.out.println("ddddd");
        System.out.println("insert user controller=>>" + userBoardVO.getcName());
        boardService.insertUser(userBoardVO);
        return "redirect:userListPage";
    }

    //사용자 상세보기화면
    @RequestMapping(value = "/UserDetail", method = RequestMethod.GET)
    public String UserDetail(
            Model model
            , @RequestParam("cNo") int cNo) throws Exception {
        UserBoardVO userDetail = boardService.UserDetail(cNo);
        System.out.println("유저디테일 : " + userDetail.getTelName());

        List<BoardVO> telCode = boardService.selectTelCode();
        model.addAttribute("selectTelCode",telCode);
        model.addAttribute("UserDetail",userDetail);
        model.addAttribute("cNo",cNo);
        return "UserDetail";
    }

    //사용자 정보수정 컨트롤러
    @RequestMapping(value = "/UserUpdate", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute UserBoardVO userBoardVO) throws Exception{

        System.out.println("hhhhh");
        System.out.println("유저업데이트 들어옴 제목은 : " + userBoardVO.getcName());
        System.out.println("userBoardVO : " + userBoardVO);
        try {
            boardService.updateUser(userBoardVO);

        }catch (Exception e){
            return e.getMessage();
        }
        return "redirect:userListPage";
    }

    //사용자 정보삭제 컨트롤러
    @RequestMapping(value = "/UserDelete")
    public String deleteUser(@RequestParam int cNo) throws Exception{
        boardService.deleteUser(cNo);
        return "redirect:userListPage";
    }


}
