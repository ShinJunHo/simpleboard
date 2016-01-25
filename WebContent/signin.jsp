<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
String id = "";
String lastTime="";
//현재 저장된 모든 쿠키를 불러온다.
Cookie[] cookies = request.getCookies();
//쿠키가 있는지 검사.
if(cookies != null && cookies.length > 0 ){
	//받아온 쿠키만큼 반복문으로 검사를 수행.
	for(int i = 0 ; i < cookies.length ; i++){
		//로그인 성공시 만들어진 id라는 이름을 가져온다.
		if(cookies[i].getName().equals("id")){// ???
			id=cookies[i].getValue();
		}
		if(cookies[i].getName().equals("lastTime")){
			lastTime=cookies[i].getValue();
		}
	}
}

%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/simpleboard/assets/icon/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/simpleboard/assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/simpleboard/assets/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  <!-- 상단 네비게이션 바 -->
  
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
            <li><a href="/simpleboard/joinform.jsp">회원가입</a></li>
            <li class="active"><a href="/simpleboard/signin.jsp">로그인</a></li>
          </ul>
        </div>
      </div>
</div>
    <div class="container">
		
      <form class="form-signin" action="MemberLogin" method="POST">
        <h2 class="form-signin-heading">로그인@</h2>
        <label for="inputEmail" class="sr-only">ID</label>
        <!--  placeholder="ID"   placeholder="Password"  required autofocus -->
        <input type="text" id="userid" name="userid" class="form-control" value=<%=id%> >
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" id="idstore" name="idstore" value="store" checked>ID 저장
          </label>
        </div>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in">
      </form>
마지막 로그인 시간::<%=lastTime %>
<!--  Session 으로  index페이지로 넘어가서 주는거랑
아직 처리를 안해서 .. Cookies를 이용하여 LoginPage에서 확인하는거랑.
비슷하다. -->
    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>