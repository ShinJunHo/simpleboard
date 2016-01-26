package kr.co.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.impl.BoardDaoImpl;
import kr.co.bit.utils.DBUtil;
import kr.co.bit.vo.BoardVo;

/**
 * Servlet implementation class UserboardDetail
 * 글의 세부정보를 확인하기위한 Controller.
 */
@WebServlet("/UserboardDetail")
public class UserboardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserboardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//글 번호 받아옴.
		int req = Integer.parseInt(request.getParameter("seq"));
		BoardDaoImpl boardDao = new BoardDaoImpl(DBUtil.getDBConnection());
		BoardVo b = boardDao.userBoardDetail(req);
		
		DBUtil.releaseConnection();
		DBUtil.releaseStatement(boardDao.getPstmt());

		if(b != null){
			// forwarding 방식을 통해서 데이터를 불러온거.
			//페이지 교체.
			RequestDispatcher rd = request.getRequestDispatcher("/userboarddetail.jsp");
			request.setAttribute("BoardVo", b);
			rd.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
