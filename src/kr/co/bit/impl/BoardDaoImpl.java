package kr.co.bit.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
				sql += "order by seq desc";
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
	@Override
	public BoardVo userBoardDetail(int seq) {
		// TODO Auto-generated method stub
		String sql = "select seq,user_id,title,contents,to_char(modifydate,'yyyy/mm/dd') as modi_date from tb_board where seq = ?";
		BoardVo vo=null ;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo = new BoardVo();
				vo.setBoard_seq(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContents(rs.getString(4));
				vo.setModi_date(rs.getString(5));
			}
			return vo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public boolean boardInsert(Map<String, String> mParam) {
		// TODO Auto-generated method stub
		String sql="insert into tb_board values(BOARD_SEQ.nextval,?,?,?,sysdate)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mParam.get("userid"));
			pstmt.setString(2, mParam.get("title"));
			pstmt.setString(3, mParam.get("contents"));
			
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public void update(Map<String, String> mParam) {
		// TODO Auto-generated method stub
		String sql = "update TB_BOARD set TITLE = ?,CONTENTS = ? where USER_ID = ?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mParam.get(""));
			pstmt.setString(2, mParam.get(""));
			pstmt.setString(3, mParam.get(""));
		}catch(SQLException e){
			e.printStackTrace();
			
		}
	}
	@Override
	public void deleteItem(int seq) {
		// TODO Auto-generated method stub
		String sql ="delete from TB_BOARD where seq = ?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,seq);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
