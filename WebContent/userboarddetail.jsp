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
		//�α����� ���
		String LoginUser = (String)session.getAttribute("LOGINID");
		//�ۼ��� ������ ����. // parameter�� �ѱ� �ʿ䰡 ����~
		String writer = FunctionClass.getString(b.getId());
		
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<script type="text/javascript">
	
		function updateItem(){
			//Ȥ�� if else ������ update mode�� �ؼ� �� �ؾ��ϴ°ǰ�?.
			//alert("update");
			document.getElementById("mode").value = "update";
			//Ajax ����ҵ��ѵ�.
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
		�ۼ��� : <% if(mode.equals("read")){ %>
				<%=FunctionClass.getString(b.getId())%>
			<%}else if(mode.equals("write")){ %>
				<%=LoginUser %>
				<%} %>
		<br/>
		<!--  ��ĭ�� null�� �ȳ����� �ϴ� ȿ���� �ֳ�. -->
		���� :<input type="text" name="title" value="<%=FunctionClass.getString(b.getTitle())%>" 
				<% if( mode.equals("read")){ %>
					readonly="readonly"
				<%}%>><br/>
		���� :<br/>
			<!-- ������ Read Only -->
		<textarea name="contents" rows="10" cols="50" <% if(mode.equals("read")){ %>
					readonly="readonly"
					<%} %>>
		<%=FunctionClass.getString(b.getContents()) %> 
		</textarea><br/>
		
		<input type="submit" value="���">
		<!--  �α��� ���̵�� �ۼ��� ���̴ٰ� ������ �� ���� & ����. -->
		<% if(!mode.equals("write")) {%>
			<% if(LoginUser.equals(writer)){ %>
			<input type="button" id="update" value="����" onclick="updateItem()">
			<input type="button" id="delete" value="����" onclick="deleteItem()">
			<%} %>
		<%} %>
		<button>���</button>
		<!-- hidden�� ���� �������� ��� �൵�� �� ������ �����Ѵ�. -->
		<input type="hidden" id="mode" name="mode" value="<%=mode %>">
	</form>
	</center>
</body>
</html>