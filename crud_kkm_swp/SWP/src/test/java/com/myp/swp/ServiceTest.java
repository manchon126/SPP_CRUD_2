package com.myp.swp;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myp.swp.domain.BoardVO;
import com.myp.swp.domain.Criteria;
import com.myp.swp.service.BoardService;

//Runner 클래스(테스트 메소드를 실행하는 클래스) 를 SpringJUnit4ClassRunner로 함
@RunWith(SpringJUnit4ClassRunner.class)
//location 속성 경로에 있는 xml 파일을 이용해서 스프링이 로딩됨
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class ServiceTest {
	@Inject
	private BoardService service;
	private static Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	
	
    
	@Test
	public void listPageTest() throws Exception{
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(10);
		List<BoardVO> boards = service.listPage(cri);
		for (BoardVO board : boards) {
			logger.info(board.getBno()+ ":" + board.getTitle());
		}		
	}
	
	@Test
	public void getTotalCountTest() throws Exception {
		Criteria cri = new Criteria();
		Integer totalCount = service.getTotalCount(cri);
		logger.info("totalCount: "+totalCount.toString());
	}
}
