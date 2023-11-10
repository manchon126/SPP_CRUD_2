<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html> 
<html>
<head>
<title>게시판 목록</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#hrefGoogle").click(function(){
		$(location).attr("href", "https://www.google.com/")
	})
	
})
</script>
</head>
<form action = "regist" method = "get">
<body>
	<table border="1" width="880">
		<tr>
        <td width="77">
            <p align="center">글번호</p>
        </td>
        <td width="327">
            <p align="center">제목</p>
        </td>
        <td width="197">
            <p align="center">작성자</p>
        </td>
        <td width="155">
            <p align="center">abc</p>
        </td>
        <td width="90">
            <p align="center">조회수</p>
        </td>
     	</tr>        

        <c:forEach items="${list}" var="boardDTO">
	<tr>
        <td>${boardDTO.bno}</td>
        <td><a href='/read?bno=${boardDTO.bno}'>${boardDTO.title}</a></td>
        <td>${boardDTO.writer}</td>
        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
				value="${boardDTO.regdate}" /></td>
        <td><span class="badge bg-red">${boardDTO.viewcnt}</span></td>
	</tr>
		</c:forEach>
    </table>
     <button type ="submit">글쓰기</button>
     <button type ="button" id ="hrefGoogle">구글 링크</button>
   </body>
    </form>

</html>