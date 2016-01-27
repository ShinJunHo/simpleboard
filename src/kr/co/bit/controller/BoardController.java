package kr.co.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.impl.BoardDaoImpl;
import kr.co.bit.utils.Constants;
import kr.co.bit.utils.DBUtil;
import kr.co.bit.utils.FunctionClass;
import kr.co.bit.vo.BoardVo;

/**
 * Servlet implementation class BoardController
 * 게시판 내용을 가지고 오는 Controller
 */
@WebServlet("/Board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGetPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGetPost(request,response);
		
	}
	private void doGetPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//로그인 세션관련
		String loginId = (String)request.getSession().getAttribute("LOGINID");
		
		
		//세션에 로그인 아이디가 없으므로 로그인이 되지 않았다고 판단됨.
		if(FunctionClass.getString(loginId).equals("")){
			//response.sendRedirect("index.html");
			response.sendRedirect("join.jsp?msg=loginplease");
		}else{
		BoardDaoImpl boardDao = new BoardDaoImpl(DBUtil.getDBConnection());
		
		//전체검색
		List<BoardVo> mBoardArr = boardDao.selectBoard(Constants.WHOLE, "");
		//System.out.println("Board"+mBoardArr);
		DBUtil.releaseStatement(boardDao.getPstmt());
		DBUtil.releaseConnection();
		
		RequestDispatcher rd = request.getRequestDispatcher("/userBoard.jsp");
		request.setAttribute("BoardList", mBoardArr);
		rd.forward(request, response);
		}
	}
}
