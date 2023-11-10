package com.myp.swp.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myp.swp.domain.BoardVO;
import com.myp.swp.domain.Criteria;
import com.myp.swp.domain.PageMaker;
import com.myp.swp.service.BoardService;

@Controller
@RequestMapping("/board/*") //http://localhost:8080/board 인 경우에 먼저 호출되는 클래스 
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
    //서비스 객체 (쿼리문 실행)
	@Inject
	private BoardService service;
	
    /* http://localhost:8080/board/register 인 경우에 호출
     등록을 위한 입력 페이지 register.jsp 보여줌(GET 방식)*/
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, 
			        @ModelAttribute("cri") Criteria cri,
				Model model) throws Exception{
		logger.info("register get.....");
	}
	
    /* register.jsp 에 있는 post 방식의 form 태그에서 submit이 된 경우 호출
    전달받은 게시물을 등록함(POST 방식) */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board,
				   Criteria cri,
				   RedirectAttributes rttr) throws Exception{
		logger.info("register post.....");
		logger.info(board.toString());
		
		service.regist(board);
		
		rttr.addFlashAttribute("result", "registerOK");
	         //등록 후에는 1페이지로 이동해야하므로 page 값으로 1 전달
		rttr.addAttribute("page", 1);
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		
		return "redirect:/board/listPage";
	}

	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") Integer bno, 
			 @ModelAttribute("cri") Criteria cri, 
			 Model model) throws Exception{
		logger.info("read GET...");
		BoardVO board = service.read(bno);
		model.addAttribute(board);
	}
	
	//update.jsp 보여줌
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updateGET(@RequestParam("bno") Integer bno, 
			      @ModelAttribute("cri") Criteria cri, 
			      Model model) throws Exception{
		logger.info("update GET");
		BoardVO board = service.read(bno);
		model.addAttribute(board);
	}
    
    //실제로 게시물을 수정함s
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(BoardVO board, 
				 Criteria cri,
				 RedirectAttributes rttr) throws Exception{
		logger.info("update POST");
		service.modify(board);
		rttr.addFlashAttribute("result","saveOK");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("bno", board.getBno());
		return "redirect:/board/read";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@RequestParam("bno") Integer bno, 
			     Criteria cri,
			     RedirectAttributes rttr) throws Exception{
		logger.info("remove");
		service.remove(bno);
		rttr.addFlashAttribute("result","removeOK");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		logger.info("show all list");
		List<BoardVO> boards = service.listAll(); //서비스 객체의 listAll() 메소드 호출
		model.addAttribute("list",boards); //조회결과를 model의 list속성으로 추가
	}	
	
	@RequestMapping(value = "/dummy")
	public String dummyPOST(RedirectAttributes rttr) throws Exception{
		logger.info("dummy post.....");
			
		service.dummy();
			
		rttr.addFlashAttribute("result", "registerOK");
		return "redirect:/board/listAll";
	}
	
	//페이징 기능으로 목록을 보여주는 메서드
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception{
		logger.info("listPage");
        //현재 페이지에 해당하는 게시물을 조회해 옴 
		List<BoardVO> boards = service.listPage(cri);
        //모델에 추가
		model.addAttribute("list",boards);
        //PageMaker 객체 생성
		PageMaker pageMaker = new PageMaker(cri);
        //전체 게시물 수를 구함
		int totalCount = service.getTotalCount(cri);
        //pageMaker로 전달 -> pageMaker는 startPage, endPage, prev, next를 계산함
		pageMaker.setTotalCount(totalCount);
        //모델에 추가
		model.addAttribute("pageMaker", pageMaker);
	}
}
