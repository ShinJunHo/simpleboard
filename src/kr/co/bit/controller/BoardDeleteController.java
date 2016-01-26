package kr.co.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.impl.BoardDaoImpl;
import kr.co.bit.utils.DBUtil;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/BoardDeleteController")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HELLO DELETE");
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		BoardDaoImpl boardDao = new BoardDaoImpl(DBUtil.getDBConnection());
		boardDao.deleteItem(seq);
		
		DBUtil.releaseConnection();
		DBUtil.releaseStatement(boardDao.getPstmt());
		response.sendRedirect("Board");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	
	
	}

}
