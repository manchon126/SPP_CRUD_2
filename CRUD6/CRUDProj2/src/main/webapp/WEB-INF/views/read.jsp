<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>글읽기</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" ></script>
<script type="text/javascript">
$(document).ready(function(){

	$("#goPrev").click(function(){
		history.go(-1)();
	})

})
</script>
</head>
<form>
<body>

<p><label>글번호</label> <input type="text" name ="bno" value ="" readonly="readonly"></p>
<p><label>제목</label> <input type="text" name ="title" style="background-color:#B0E0E6;" value ="" readonly="readonly"></p>
<p><label>작성자</label> <input type="text" name="writer" size="15" value = "" readonly="readonly"><p>
<label>내용</label> <textarea name="content" rows ="10" cols="70"  style="background-color:#B0E0E6; "readonly="readonly">본문 영역</textarea><br>

<button type="submit" formaction="modify" formmethod="post">수정</button>
</form>
<button type="submit" id="btnWritingDelete">삭제</button>
<button type="submit" onclick="location.href='/test'">목록</button>
<button type="button" id="goPrev">뒤로가기</button>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="/resources/js/crud.js"></script> <!-- crud.js -->
<script>
$(function(){
	bno = ${param.bno};
	readWriting(bno);
	
	$('#btnWritingDelete').click(function(){
		removeWriting(bno);
	})  
})
</script>
</body>
</html>

