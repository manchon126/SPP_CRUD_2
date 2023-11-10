package com.myp.service;

import java.util.List;

import com.myp.domain.BoardDTO;

/**
 * 게시판 CRUD의 비즈니스 로직을 수행할 서비스의 인터페이스 
 * @author 최욱철
 * @since 2023-10-11
 */
public interface BoardService {

	public List<BoardDTO> getBoardList();
	public List<BoardDTO> getBoardListByUserId(String writer);
	public BoardDTO getBoardById(Integer bno);
	public void createBoard(BoardDTO boardDTO);
	public void updatePost(BoardDTO boardDTO);
	public void deletePost(Integer bno);
}
