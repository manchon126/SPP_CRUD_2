package com.myp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myp.domain.BoardDTO;
import com.myp.mapper.PostMapper;
//import com.myp.persistence.BoardDAO;

/**
 * 게시판 CRUD의 비즈니스 로직을 수행할 서비스의 구현체 
 * @author 최욱철
 * @since 2023-10-11
 */
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private PostMapper postMapper;

	public List<BoardDTO> getBoardList() {
		return postMapper.getPostList();
	}
	
	public List<BoardDTO> getBoardListByUserId(String writer) {
		return postMapper.getPostListByUserId(writer);
	}
	
	public BoardDTO getBoardById(Integer bno) {
		return postMapper.getPostById(bno);
	}
	
	public void createBoard(BoardDTO boardDTO) {
		postMapper.insertPost(boardDTO);
	}
	
	public void updatePost(BoardDTO boardDTO) {
		postMapper.updatePost(boardDTO);
	}
	
	public void deletePost(Integer bno) {
		postMapper.deletePost(bno);
	}
}
