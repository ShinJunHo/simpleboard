<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.List" %>
<%@ page import = "kr.co.bit.vo.BoardVo" %>
<jsp:useBean id="beans" class="kr.co.bit.vo.UserVo" scope="session"/>
<!--  로그인 성공시 User의 정보가 보여지게. -->
<%
  	List<BoardVo> list = (List)request.getAttribute("BoardList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="index.jsp">홈으로</a></h1><hr/>
	<%=beans.getId() %> 님 환영합니다.<br/>
	<h1><a href="userboarddetail.jsp?mode=write">게시글쓰기</a><br/></h1>
	<% for( BoardVo b : list) {%>
	<b><%=b.getBoard_seq() %></b>
	<a href ="UserboardDetail?seq=<%=b.getBoard_seq()%>&mode=read">
	<b><%=b.getTitle() %></b></a>
	<b><%=b.getId() %></b>
	<b><%=b.getModi_date() %></b>
	<br/>
	<%} %>
	
</body>
</html>