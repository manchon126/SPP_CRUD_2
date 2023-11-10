<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE>
<html>
<head>
<title>글수정</title>
</head>
<body>
글 수정 페이지

    <p><label>글번호</label> <input type="text" id ="bno" value ="${boardDTO.bno}" readonly="readonly"></p>
    <p><label>제목</label ><input type="text" id ="title" value ="${boardDTO.title}" ></p>
    <p><label>작성자</label> <input type="text" id="writer" size="15" value = "${boardDTO.writer}" readonly="readonly"></p>
    <label>내용</label>
    <textarea id="content" rows ="10" cols="70" >${boardDTO.content}</textarea><br>
    
    <button id="btnWritingUpdate" type ="submit">완료</button>
    
</body>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="/resources/js/crud.js"></script> <!-- crud.js -->
<script>
$(function(){	
	let bno = $('#bno').val();
	
	$('#btnWritingUpdate').click(function(){
		let modified;
		modified = updateWriting();
	})
});
</script>

</html>