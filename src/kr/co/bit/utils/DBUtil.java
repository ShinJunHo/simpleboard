package kr.co.bit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * 
 *Connection 객체 얻어오기
 *자원해제 기능 모음.
 * @author bit-user
 *
 */
public class DBUtil {
	private static Connection conn = null;
	public static Connection getDBConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String jId = "scott1";
		String jpassword = "tiger1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url, jId, jpassword);
			System.out.println("연결 성공");
		} catch (ClassNotFoundException ex) {
			System.out.println("classNotFound");
			ex.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	public static boolean releaseStatement(Statement stmt){
		try{
			stmt.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean releaseResultSet(ResultSet rs){
		try{
			rs.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public static boolean releaseConnection(){
		try{
			conn.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
}
