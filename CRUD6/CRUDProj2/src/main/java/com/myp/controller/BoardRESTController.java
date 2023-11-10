package com.myp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myp.domain.BoardDTO;
import com.myp.service.BoardService;

/**
 * 게시판 목록 표시 및 CRUD 처리 관련 controller
 * @author 최욱철
 * @since 2023-10-11
 */
//@Controller // 컨트롤러임을 명시
@RestController
@RequestMapping(value = "/") // 주소 패턴
public class BoardRESTController {

	//@Inject   // 주입(심부름꾼) 명시
	@Autowired
	private BoardService boardService; // Service 호출을 위한 객체생성
	
	@PostMapping("/posts") 
	public void createPost(@RequestBody BoardDTO boardDTO) {
		boardService.createBoard(boardDTO);
	}
	
	@GetMapping("/posts")
	public Map<String, Object> listPage() {
		Map<String, Object> map = new HashMap<>();
		
		List<BoardDTO> list = boardService.getBoardList();
		map.put("list", list);
		
		return map;
	}
	
	@GetMapping("/posts/{bno}")
	public Map<String, BoardDTO> showPost(@PathVariable Integer bno) {
		Map<String, BoardDTO> map = new HashMap<>();		

		BoardDTO boardDTO = boardService.getBoardById(bno);
		map.put("boardDTO", boardDTO);
		
		return map;
	}
	
	@PutMapping("/posts/{bno}")
	public void editPost(@PathVariable Integer bno, @RequestBody BoardDTO boardDTO) {
		boardDTO.setBno(bno);
		boardService.updatePost(boardDTO);
	}
	
	@DeleteMapping("/posts/{bno}")
	public void deletePost(@PathVariable Integer bno) {
		boardService.deletePost(bno);
	}
}

