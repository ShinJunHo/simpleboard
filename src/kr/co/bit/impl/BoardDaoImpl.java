package kr.co.bit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.dao.BoardDao;
import kr.co.bit.utils.Constants;
import kr.co.bit.vo.BoardVo;

public class BoardDaoImpl implements BoardDao {

	Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public BoardDaoImpl(Connection conn){
		this.conn=conn;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	@Override
	public List<BoardVo> selectBoard(String searchKind, String searchWord) {
		// TODO Auto-generated method stub
		
		List<BoardVo> list=null ;
		
		String sql = "select seq, user_id, title, modifydate from tb_board ";
		try {
			switch (searchKind) {

			case Constants.TITLE_CONTENTS:
				sql += "where title like '%'||?||'%' or contents like '%'||?||'%' ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, searchWord);
				pstmt.setString(2, searchWord);
				break;

			case Constants.USER:
				sql += "where user_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, searchWord);
				break;

			default:
				pstmt = conn.prepareStatement(sql);
				break;
			}
			System.out.println(sql);
			rs = pstmt.executeQuery();
			//쿼리 실행 후 결과값을 resultset 에 집어 넣음
			list = new ArrayList<BoardVo>();
			while(rs.next()){
				BoardVo vo = new BoardVo();
				vo.setBoard_seq(rs.getInt(("SEQ")));
				vo.setTitle(rs.getString("TITLE"));
				vo.setId(rs.getString("USER_ID"));
				vo.setModi_date(rs.getString("modifydate"));
				list.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
