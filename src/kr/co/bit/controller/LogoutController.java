package kr.co.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 
 * 
 * 로그아웃 컨트롤러.
 * @author bit-user
 *
 */
@WebServlet("/MemberLogout")
public class LogoutController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션을 가지고 와서
		HttpSession session = request.getSession();
		//세션 초기화
		session.invalidate();
		
		//1) JSP 에서 처리할 수 있고
		//2) index로 넘어가기 위해 여기서 처리를 하고.
		response.sendRedirect("index.jsp");
		
	
	}
}
