package kr.co.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.impl.UserDaoImpl;
import kr.co.bit.utils.DBUtil;

/**
 * Servlet implementation class LoginController
 * 
 * Login Controller
 */
@WebServlet("/MemberLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	 	로그인 처리.
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");
		
		System.out.println(userId+password);
		
		UserDaoImpl userDao = new UserDaoImpl(DBUtil.getDBConnection());
		boolean isLogin = userDao.login(userId, password);
		DBUtil.releaseConnection();
		DBUtil.releaseStatement(userDao.getPstmt());
		DBUtil.releaseResultSet(userDao.getRs());
		
		if(isLogin){
			//성공시
			// '/'가 붙는 이유는 무엇일까 ? sendRedirect 했을때 
			// 프로젝트명을 설정을 안해줬기에. 나중엔 '/'을 붙여주고.
			
			//getSession() 메소드를 통해
			//세션 객체를 가지고 온다.
			request.getSession().setAttribute("LOGINID",userId );
			response.sendRedirect("index.jsp");
		}else{
			//실패시
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("msg", "로그인실패");
			rd.forward(request, response);
			
		}
	
	}

}
