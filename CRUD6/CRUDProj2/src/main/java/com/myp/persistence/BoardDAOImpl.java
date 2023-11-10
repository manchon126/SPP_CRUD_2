//package com.myp.persistence;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.stereotype.Repository;
//
//import com.myp.domain.BoardDTO;
//
///**
// * 게시판 DB에 접근할 DAO의 구현체
// * @author 최욱철
// * @since 2023-10-11
// */
//@Repository
//public class BoardDAOImpl implements BoardDAO {
//
//	@Inject
//	private SqlSession session;
//	private static String namespace = "com.myp.mapper.BoardMapper";	
//
//	@Override
//	public BoardDTO create(BoardDTO dto) throws Exception {
//		session.insert(namespace+".create", dto);
//		return session.selectOne(namespace + ".read", dto.getBno());
//	}
//
//	@Override
//	public BoardDTO read(Integer bno) throws Exception {
//		return session.selectOne(namespace + ".read", bno);
//	}
//
//	@Override
//	public void update(Integer bno, BoardDTO dto) throws Exception {
//		session.update(namespace+".update", dto);
//	}
//
//	@Override
//	public void delete(Integer bno) throws Exception {
//		session.delete(namespace+".delete", bno);
//	}
//	
//	@Override
//	public List<BoardDTO> listAll() throws Exception {
//		return session.selectList(namespace + ".listAll");
//	}
//
//}
