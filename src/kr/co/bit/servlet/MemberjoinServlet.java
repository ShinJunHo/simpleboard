package kr.co.bit.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberjoinServlet
 */
/**
 * 
 * Member Join 연습용 Servlet
 * @author bit-user
 *
 */
@WebServlet("/Memberjoin777")
public class MemberjoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberjoinServlet() {
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
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String jId = "scott1";
		String jpassword = "tiger1";
		Connection conn = null;
		System.out.println("USERId "+ userId);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url, jId, jpassword);
			System.out.println("연결 성공");
			
			String query = "insert into TB_USER values(USER_SEQ.NEXTVAL,?,?,?,?,?,sysdate)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, phone);
			pstmt.setInt(5, age);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//1)SendRedirect 방식
		//response.sendRedirect("joinComplete.jsp?userId="+userId);
		
		//2)Forwarding 방식
		RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		request.setAttribute("msg", userId);
		rd.forward(request, response);
		
		
	
	
	}

}
