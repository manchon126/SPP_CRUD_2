<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %> <!-- 사용자가 접속하면 한 개의 세션이 생김 false면 세션을 사용안함-->

<%@include file="../include/header.jsp" %>

<div id="registerOK" class="alert alert-info hidden" role="alert">새 글이 등록되었습니다.</div>	
<div id="removeOK" class="alert alert-danger hidden" role="alert">글이 삭제되었습니다.</div>


<table class="table table-bordered">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px">VIEWCNT</th>
	</tr>
	<!-- for 문 -->
	<c:forEach items="${list}" var="boardVO"> <!-- model의 속성 list에 담겨있는 조회결과를 차례로 boardVO에 대입-->
		<tr>
			<td>${ boardVO.bno }</td>
			<td><a href="/board/read?bno=${boardVO.bno}">${ boardVO.title }</a></td>
			<td>${ boardVO.writer}</td>
			<td><fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss" value="${ boardVO.regdate}"/></td>
			<td>${ boardVO.viewcnt}</td>
		</tr>
	</c:forEach>
</table>

<div>
	<!-- 등록페이지로 가는 버튼 -->
	<a href="/board/register"><button class="btn btn-primary">새글등록</button></a>
	<a href="/board/dummy"><button class="btn btn-primary">dummy생성</button></a>
</div>

<script>
	var result = '${result}';
	$(function(){
		if(result === 'registerOK'){
			$('#registerOK').removeClass('hidden');
			$('#registerOK').fadeOut(2000);
		}
		if(result === 'removeOK'){
			$('#removeOK').removeClass('hidden');
			$('#removeOK').fadeOut(2000);
		}
	})
</script>
<%@include file="../include/footer.jsp" %>