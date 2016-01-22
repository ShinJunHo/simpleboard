package kr.co.bit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.co.bit.dao.UserDao;
import kr.co.bit.vo.UserVo;

public class UserDaoImpl implements UserDao {
	Connection conn;
	
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//Controller에서 DB커넥션을 받아옴.
	public UserDaoImpl(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	
	@Override
	public boolean userInsert(Map<String, String> mParam) {
		// TODO Auto-generated method stub
		String query="insert into tb_user values(user_seq.nextval,?,?,?,?,?,sysdate)";
		try{
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, mParam.get("userId"));
			pstmt.setString(2, mParam.get("password"));
			pstmt.setString(3, mParam.get("email"));
			pstmt.setString(4, mParam.get("phone"));
			pstmt.setInt(5, Integer.valueOf(mParam.get("age")));
			
			pstmt.executeUpdate();
			
			return true;
		}catch(SQLException ex){
			ex.printStackTrace();
			return false;
		}
		
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}




	public ResultSet getRs() {
		return rs;
	}
	
	@Override
	public boolean userUpdate(Map<String, String> mParam) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userDelete(String mUserId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserVo> userSelect(Map<String, String> mParam) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean login(String id, String password){
		String sql = "select DECODE (count(*),1,'TRUE',0,'FALSE') as Login from tb_user where user_id=? and password=?";
		try{
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, password);
			//쿼리 실행
			rs = pstmt.executeQuery();
			rs.next();
			// 여기서 rs 예외 처리를 해주는것은 어떨까 ?.
			
			//질의 결과를 받아온다.(쿼리 실행 값이 True이면 로그인 성공. False면 실패.
			String loginResult = rs.getString("Login");
			if(loginResult.equals("TRUE"))
				return true;
			else
				return false;
		}catch(SQLException ex){
			ex.printStackTrace();
			return false;
		}
	}

}
