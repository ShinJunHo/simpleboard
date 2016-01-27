package kr.co.bit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.impl.BoardDaoImpl;
import kr.co.bit.utils.DBUtil;

/**
 * Servlet implementation class BoardInsertContrller
 */
@WebServlet("/BoardInsertContrller")
public class BoardInsertContrller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertContrller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		//세션에서 ID 받아오기,
		String userid = (String)request.getSession().getAttribute("LOGINID");
		String title = request.getParameter("title");
		String content = request.getParameter("content").trim();
		String seq = request.getParameter("seq");
		String mode = request.getParameter("mode");
		System.out.println("mode::"+mode);
		BoardDaoImpl boardDao = new BoardDaoImpl(DBUtil.getDBConnection());
		Map<String,String> map = new HashMap<String,String>();
		
		boolean flag =false;
		map.put("userid", userid);
		map.put("title", title);
		map.put("content", content);
		map.put("seq",seq);
		
		if(mode.equals("write")){
			flag = boardDao.boardInsert(map);
		}else if(mode.equals("modify")){
			flag = boardDao.boardModify(map);
		}
		
		if(flag != true){
			System.out.println("입력 실패.");
			response.sendRedirect("Board");
		}else{
			System.out.println("입력 성공.");
			//board servlet호출해서 게시판으로.
			response.sendRedirect("Board");
		}
		
		DBUtil.releaseConnection();
		DBUtil.releaseStatement(boardDao.getPstmt());
	}

}
