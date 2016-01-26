<%@page import="kr.co.bit.utils.FunctionClass"%>
<%@page import="java.util.function.Function"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "kr.co.bit.vo.BoardVo" %>
    <% 
    	BoardVo b = (BoardVo)request.getAttribute("BoardVo");
    
    	if(b == null){
    		b= new BoardVo();
    	}
    	String mode = request.getParameter("mode");
		out.println(mode);
		//로그인한 사람
		String LoginUser = (String)session.getAttribute("LOGINID");
		//작성자 가지고 오기. // parameter로 넘길 필요가 없다~
		String writer = FunctionClass.getString(b.getId());
		
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<script type="text/javascript">
	
		function updateItem(){
			//혹시 if else 문으로 update mode를 해서 더 해야하는건가?.
			//alert("update");
			document.getElementById("mode").value = "update";
			//Ajax 써야할듯한데.
			//window.location.href="BoardUpdateController";
			console.log(document.getElementById("mode").value);
		}
		
		
		function deleteItem() {
			var seq = document.getElementById('seq').value;
			window.location.href = "BoardDeleteController?seq="+seq;
		}
	</script>
</head>
<body>
	<center>
	<form action="BoardInsertContrller" method="POST" >
		<input type="hidden" id="seq" value="<%=b.getBoard_seq() %>">
		작성자 : <% if(mode.equals("read")){ %>
				<%=FunctionClass.getString(b.getId())%>
			<%}else if(mode.equals("write")){ %>
				<%=LoginUser %>
				<%} %>
		<br/>
		<!--  빈칸에 null이 안나오게 하는 효과가 있넹. -->
		제목 :<input type="text" name="title" value="<%=FunctionClass.getString(b.getTitle())%>" 
				<% if( mode.equals("read")){ %>
					readonly="readonly"
				<%}%>><br/>
		내용 :<br/>
			<!-- 지금은 Read Only -->
		<textarea name="contents" rows="10" cols="50" <% if(mode.equals("read")){ %>
					readonly="readonly"
					<%} %>>
		<%=FunctionClass.getString(b.getContents()) %> 
		</textarea><br/>
		
		<input type="submit" value="등록">
		<!--  로그인 아이디와 작성자 아이다가 같을때 만 수정 & 삭제. -->
		<% if(!mode.equals("write")) {%>
			<% if(LoginUser.equals(writer)){ %>
			<input type="button" id="update" value="수정" onclick="updateItem()">
			<input type="button" id="delete" value="삭제" onclick="deleteItem()">
			<%} %>
		<%} %>
		<button>목록</button>
		<!-- hidden을 통해 서블릿에서 어떠한 행도을 할 것인지 결정한다. -->
		<input type="hidden" id="mode" name="mode" value="<%=mode %>">
	</form>
	</center>
</body>
</html>