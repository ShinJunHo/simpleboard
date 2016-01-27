<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<!-- 경로를 프로젝트명/경로를 살려줘야 하는구나 이렇게. -->
<!-- 
Bootstrap location
Latest compiled and minified CSS 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
Optional theme 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
 Latest compiled and minified JavaScript 
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

 -->
<link rel="stylesheet" href="/simpleboard/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/simpleboard/assets/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="/simpleboard/assets/js/bootstrap.min.js"></script>
<style>
.centeringContainer {
	text-align: center;
}

.centered {
	display: table;
	margin-left: auto;
	margin-righ: auto;
	display: inline-block;
}
</style>
</head>
<body>
<!-- 상단 네비게이션 바 -->
<!--  html 에서 jsp 로 바꾸고. Include 페이지를 해주면 더 효율적이겠다. -->
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <!-- 브라우저가 좁아졋을때 나오는 버튼(클릭시 메뉴출력) -->
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">쏘민호 강사의 웹교실 at R43</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/simpleboard/index.jsp">홈으로</a></li>
            <li class="active"><a href="/simpleboard/joinform.jsp">회원가입</a></li>
            <li><a href="/simpleboard/signin.jsp">로그인</a></li>
          </ul>
        </div>
      </div>
</div>
	<!-- 회원가입 기본 템플릿입니다  
	여러분은 부트스트랩을 이용하여 다양한 기능을 구현할수 있습니다. 
	container-->
	<div class="centeringContainer">
		<div style="margin-top: 100px;">
			<h1>회원가입 화면.</h1>
			<p class="lead">Bit Computer Center R43 class</p>
		</div>
	</div>
	<div class="centeringContainer">
		<span class="centered">
			<hr />
			<form action="Memberjoin" method="POST" enctype="multipart/form-data">
				ID :<input type="text" name="ID"><br>
				Password:<input type="password" name="PW"><br> 
				EMAIL :<input type="text" name="EMAIL"><br>
				PHONE :<input type="text" name="PHONE"><br> 
				AGE :<input type="text" name="AGE" maxlength="3"><br>
				Picture : <input type="file" name="picture"><br/>
				<input type="submit" value="확인">
			</form>
		</span>
	</div>
</body>
</html>