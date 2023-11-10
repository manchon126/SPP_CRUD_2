<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- bootstrap css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

</head>
<body>

	<nav id="navbar-example2" class="navbar bg-body-tertiary px-3 mb-3">
	  <a class="navbar-brand" href="/">홈으로</a>
	  <ul class="nav nav-pills">
	    <li class="nav-item">
	      <button type ="submit" onclick="location.href='/test'">게시판</button>
	    </li>
	    <li class="nav-item">
	      <button>로그인</button>
	    </li>
	  </ul>
	</nav>
 
</body>

<script type="text/javascript">
    $(function() {
          
    });    
</script>

</html>
