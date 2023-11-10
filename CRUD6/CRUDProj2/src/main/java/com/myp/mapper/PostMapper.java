package com.myp.mapper;

import java.util.List;

import com.myp.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
	List<BoardDTO> getPostList();
    List<BoardDTO> getPostListByUserId(String writer);
    BoardDTO getPostById(Integer bno);
    void insertPost(BoardDTO boardDTO);
    int updatePost(BoardDTO boardDTO);
    int deletePost(Integer bno);
}
