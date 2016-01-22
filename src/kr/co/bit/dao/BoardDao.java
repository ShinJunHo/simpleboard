package kr.co.bit.dao;

import java.util.List;

import kr.co.bit.vo.BoardVo;

public interface BoardDao {
//
	public List<BoardVo> selectBoard(String searchKind, String searchWord);
	//게시판 검색 쿼리를 만들어 주면 되구요.
	
	
}
