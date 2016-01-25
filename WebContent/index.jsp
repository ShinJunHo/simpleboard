<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "kr.co.bit.utils.FunctionClass" %>

<jsp:useBean id="beans" class="kr.co.bit.vo.UserVo" scope="session"/>
<!--  로그인 성공시 User의 정보가 보여지게. -->
 <%
	String msg = FunctionClass.getString((String)request.getAttribute("msg"));
 	
%>
<% 
// 로그인 실패시  
// getParameter ?msg=loginplear board controller에서..
	String msg2 = FunctionClass.getString((String)request.getParameter("msg"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<% 
String loginId=(String)session.getAttribute("LOGINID");
beans.setId(loginId);

loginId = FunctionClass.getString(loginId); 
String date = (String)session.getAttribute("date");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/simpleboard/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="/simpleboard/assets/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="/simpleboard/assets/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 상단 네비게이션 바 -->
<!--  html 에서 jsp 로 바꾸고. Include 페이지를 해주면 더 효율적이겠다. -->


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
            <li class="active"><a href="/simpleboard/index.jsp">홈으로</a></li>
            <li><a href="/simpleboard/joinform.jsp">회원가입</a></li>
            <li><a href="/simpleboard/signin.jsp">로그인</a></li>
          </ul>
        </div>
      </div>
</div>
<div class="container">
      <div style="margin-top: 100px;">
        <h1>부트스트랩 기본 템플릿입니다</h1>
        <p class="lead">여러분은 부트스트랩을 이용하여 다양한 기능을 구현할수 있습니다.</p>
      </div>
</div>
		<center>
	<% if (loginId.equals("")){ %>
		로그인 정보 :<%=loginId %>
	<%}else{ %>
		<!--  세션이 있을때 게시판 보기가 나와야 합니다. -->
		로그인 정보:<%=loginId %><br/>
		시간정보: <%=date %>	<br/>
		Nav를 로그인 -> 로그아웃으로 바꿔야겠다.<br/>
	<a href="Board">게시판보기</a>
	<a href="#">회원정보 보기.</a>
	<a href="MemberLogout">로그아웃</a>
		</center>
	<%} %>
</body>
</html>