package kr.co.bit.dao;

import java.util.List;
import java.util.Map;

import kr.co.bit.vo.BoardVo;

public interface BoardDao {
//
	public List<BoardVo> selectBoard(String searchKind, String searchWord);
	//게시판 검색 쿼리를 만들어 주면 되구요.
	
	public BoardVo userBoardDetail(int seq);
	public boolean boardInsert(Map<String,String> mParam);
	public void update(Map<String, String> mParam);
	public void deleteItem(int seq);
}
