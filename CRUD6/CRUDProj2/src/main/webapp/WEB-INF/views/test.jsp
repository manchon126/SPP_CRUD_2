<!-- test.jsp -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="/resources/css/test.css" /> <!-- test.css -->
	
	<style>
		table{
			boarder-collapse: collapse;
			boarder-spacing: 0;
		}
		th, td{
			padding: 10px 20px;
			border: 1px solid #000;
		}
	</style>
</head>
<body>
	<h2 id = "h2-title" class="point">Ajax Test Page</h2>
	
	<!-- 글 목록 -->
	<div id="tableBoardlist">
	
	</div>
		
	<form action="/regist" method="POST">	
    	<button type ="submit">글쓰기</button>	
	</form>
    <button type ="button" id ="hrefGoogle">구글 링크</button>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="/resources/js/crud.js"></script> <!-- crud.js -->
<script>
$(function(){  
	listPage(); 
})
</script>
</body>
</html>