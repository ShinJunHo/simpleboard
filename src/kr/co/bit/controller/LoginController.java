package kr.co.bit.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
			
			
			//로그인 성공시 쿠키에 값을 저장
			//체크박스에 값이 있는 경우에만 쿠키에 사용자 아이디 값을 저장.
			String checkBoxValue = request.getParameter("idstore");
			if(checkBoxValue != null ){
				
				//쿠키를 만들어서 응답객체에 넣어준다.
				Cookie cookie = new Cookie("id",userId);
				response.addCookie(cookie);
			}
			//현재 로그인한 시간을 보여주기 위해서./
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar d = Calendar.getInstance();
			String date = sdf.format(d.getTime());
			Cookie timeCookie = new Cookie("lastTime",date);
			//1)Cookie에 추가를 해서 보여주기.
			response.addCookie(timeCookie);
			
			//getSession() 메소드를 통해
			//세션 객체를 가지고 온다.
			request.getSession().setAttribute("LOGINID",userId );
			//세션에 로그인 시간을 넣을 수 있지 않을까 했다.
			//2) Session에 추가를 해서 보여주기.
			//request.getSession().setAttribute("date", date);
			response.sendRedirect("index.jsp");
		}else{
			//실패시
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("msg", "로그인실패");
			rd.forward(request, response);
			
		}
	
	}

}
