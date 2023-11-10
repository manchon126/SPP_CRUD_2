<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp" %>
<form role="form" method="post">
	<div class="box-body">
		<span><b>글번호:</b> ${boardVO.bno}</span>
		<input type="hidden" name="bno" value="${boardVO.bno }" />
		
		<input type="hidden" name="page" value="${cri.page}" />
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}" />
			
		<div class="form-group">
			<label for="title">Title</label>
			<input type="text" id="title" name="title" class="form-control" value="${boardVO.title}"/>		
		</div>
			
		<div class="form-group">
			<label for="content">Content</label>
			<textarea name="content" id="content" class="form-control" rows="3" >${boardVO.content}</textarea>		
		</div>
			
		<div class="form-group">
			<label for="writer">Writer</label>
			<input type="text" id="writer" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly"/>		
		</div>	
	</div>
	<div>
		<button type="submit" class="btn btn-primary">Save</button>
		<a href="/board/read${cri.makeQuery()}&bno=${boardVO.bno}" class="btn btn-danger">Cancel</a>
	</div>		
</form>
<%@include file="../include/footer.jsp" %>