package com.myp.swp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myp.swp.domain.BoardVO;
import com.myp.swp.domain.Criteria;
import com.myp.swp.persistence.BoardDAO;

//서비스 객체임을 알림
@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		boardDAO.create(board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return boardDAO.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		boardDAO.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		boardDAO.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDAO.listAll();
	}
	
	@Override
	public void dummy() throws Exception {
    	int maxBno;
		if(boardDAO.getMaxBno() == null)
		{
			maxBno = 0;
		}else {
			maxBno = boardDAO.getMaxBno();
		}
		BoardVO board = new BoardVO();
		
		for(int i = maxBno + 1; i < maxBno + 101; i++ ) {
			board.setTitle("dummytitle"+i);
			board.setContent("연습용 게시물입니다!");
			board.setWriter("꾸리");
			regist(board);
		}
		
	}
	
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		return boardDAO.listPage(cri);
	}
	
	@Override
	public int getTotalCount(Criteria cri) throws Exception {
		return boardDAO.getTotalCount(cri);
	}
}
