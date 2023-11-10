package com.myp.domain;

import java.util.Date;
import lombok.Data;

/**
 * 게시판 DB의 데이터로 DTO(Data Transfer Object; 계층간 데이터 교환을 위해 사용하는 객체)를 생성 하기 위한 클래스
 * @author 최욱철
 * @since 2023-10-11
 */
@Data
public class BoardDTO {
	
	private Integer bno;	
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regdate=" + regdate + ", viewcnt=" + viewcnt + "]";
	}	
	
}
