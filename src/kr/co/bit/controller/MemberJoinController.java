package kr.co.bit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.impl.UserDaoImpl;
import kr.co.bit.utils.DBUtil;

/**
 * Servlet implementation class MemberJoinController
 * 회원가입 Controller
 */
@WebServlet("/Memberjoin")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinController() {
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
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("ID");
		String password = request.getParameter("PW");
		String email = request.getParameter("EMAIL");
		String phone = request.getParameter("PHONE");
		int age= Integer.parseInt(request.getParameter("AGE"));
	
		Map<String,String> mUserInfoMap = new HashMap<String,String>();
		mUserInfoMap.put("userId", userId);
		mUserInfoMap.put("password", password);
		mUserInfoMap.put("email", email);
		mUserInfoMap.put("phone", phone);
		mUserInfoMap.put("age", String.valueOf(age));
		
		UserDaoImpl userDao = new UserDaoImpl(DBUtil.getDBConnection());
		//DB연결하는 통로 하나를 마
		boolean isSuccess = userDao.userInsert(mUserInfoMap);
		DBUtil.releaseStatement(userDao.getPstmt());
		DBUtil.releaseConnection();
		//가입 성공시.(SendRedirect)
		if(isSuccess){
			response.sendRedirect("index.html");
		}else{
			//(forward)
			//가입 실패시.
			RequestDispatcher rd = request.getRequestDispatcher("/join.jsp");
			request.setAttribute("msg","가입실패");
			rd.forward(request, response);
			
		}
		
	}

}
