<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>글쓰기</title>
</head>
<body>
<p><label>제목</label><input type="text" id ="title"></p>

<p><label>작성자</label><input type="text" id="writer" size="15">
</p>
<label>내용</label><p>
<textarea rows="15" cols="65" id = "content"></textarea><p>

<button id="btnWritingAdd" type ="submit">등록</button>	

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="/resources/js/crud.js"></script> <!-- crud.js -->
<script>
$(function(){		
	$('#btnWritingAdd').click(function(){
		registerWriting();
	})       
});
</script>
</body>
</html>

