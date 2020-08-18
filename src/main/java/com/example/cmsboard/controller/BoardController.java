package com.example.cmsboard.controller;

import com.example.cmsboard.mapper.BoardMapper;
import com.example.cmsboard.mapper.MasterMapper;
import com.example.cmsboard.service.BoardService;
import com.example.cmsboard.service.MasterService;
import com.example.cmsboard.vo.BoardVO;
import com.example.cmsboard.vo.SearchVO;
import com.example.cmsboard.vo.UserBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
            ,@RequestParam(defaultValue = "title",required = false)String searchType
            ,@RequestParam(required = false)String keyword) throws Exception {

        System.out.println("boardcontroller indexPage 컨트롤러에 들어왔음");

        searchVO.setSearchType(searchType);
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

        searchVO.setSearchType(searchType);
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
        model.addAttribute("boardDetail",BoardTelCode);
        return "boardDetail";
    }

    //글작성등록 컨트롤러
    @RequestMapping(value = "insertBoard", method = RequestMethod.POST
            , produces="application/json;charset=UTF-8")
    @ResponseBody
    public String insertBoard(HttpServletRequest request, HttpServletResponse response,
                              BoardVO boardVO) throws Exception{
        System.out.println("Ddddd");
        System.out.println("인서트보드" + boardVO.getbContent());
        boardService.insertBoard(boardVO);
     return "redirect:/";
    }


    //사용자리스트띄우기
    @RequestMapping(value = "userListPage", method = RequestMethod.GET)
    public String UserBoard(SearchVO searchVO, Model model
            ,@RequestParam(value="nowPage", required=false)String nowPage
            ,@RequestParam(value="cntPerPage", required=false)String cntPerPage
            ,@RequestParam(defaultValue = "title",required = false)String searchType
            ,@RequestParam(required = false)String keyword) throws Exception {

        System.out.println("boardcontroller userList 컨트롤러에 들어왔음");

        searchVO.setSearchType(searchType);
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

        searchVO.setSearchType(searchType);
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
}
