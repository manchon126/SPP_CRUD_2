package com.myp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myp.domain.BoardDTO;
import com.myp.service.BoardService;

/**
 * 게시판 목록 표시 및 CRUD 처리 관련 controller
 * @author 최욱철
 * @since 2023-10-11
 */
@Controller // 컨트롤러임을 명시
@RequestMapping(value = "/") // 주소 패턴
public class BoardController {

	@Inject   // 주입(심부름꾼) 명시
	private BoardService service; // Service 호출을 위한 객체생성	

//	@RequestMapping(value= "/listAll", method = RequestMethod.GET) // 주소 호출 명시 . 호출하려는 주소 와 REST 방식설정 (GET)
//	public void listAll(Model model)throws Exception { // 메소드 인자값은 model 인터페이스(jsp전달 심부름꾼)
//
//		model.addAttribute("list",service.listAll()); // jsp에 심부름할 내역(서비스 호출)	
//
//	}
	
//	@RequestMapping(value = "/regist", method = RequestMethod.GET) // GET 방식으로 페이지 호출
//	public void registerGET(BoardDTO board, Model model) throws Exception {
//
//	}

	/**
	 * 게시판으로 글을 쓰기 위해 regist.jsp 호출
	 * @author 최욱철
	 * @since 2023-10-11
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST) // POST방식으로 내용 전송
	public String registPOST(BoardDTO board, RedirectAttributes rttr) throws Exception { // 인자값으로 REDIRECT 사용     

		return "regist"; // 글작성 서비스 호출
//	    return "redirect:/listAll"; // 작성이 완료된 후, 목록페이지로 리턴
	}
	
	/**
	 * 글을 읽기 위해서 메서드 글 번호(bno)을 파라미터로  read.jsp 호출
	 * @author 최욱철
	 * @since 2023-10-11
	 */
	@RequestMapping(value = "/read", method = RequestMethod.GET) // GET 방식으로 페이지 호출
	public String read(@RequestParam("bno")int bno, Model model) throws Exception{
		// 인자값은 파라미터 값으로 기본키인 글번호를 기준으로 Model을 사용하여 불러옴
		return "read"; // read 서비스 호출	 
	}
	
//	@RequestMapping(value = "/modify", method = RequestMethod.GET) // GET 방식으로 페이지 호출
//	public String modifyGET(int bno, Model model) throws Exception {
//		return "read"; // 수정을 위한 글읽기 서비스 호출
//	}	  

	/**
	 * 글 수정을 위해 BoardDTO를 매개변수로 modify.jsp를 호출
	 * @param board
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)// POST방식으로 데이터 전송
	 public String modifyPOST(BoardDTO board, RedirectAttributes rttr) throws Exception {
		return "modify"; // 글수정 서비스 호출
	    //return "redirect:/listAll"; // 수정이 완료된 후, 목록페이지로 리턴
	}
	  
	/**
	 * 
	 * @param bno
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)// POST방식으로 데이터 전송
	public String removePOST(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		return "remove"; // 글삭제 서비스 호출
		//return "redirect:/listAll"; // 삭제가 완료된 후, 목록페이지로 리턴
	}
	  
}

