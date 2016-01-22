package kr.co.bit.dao;

import java.util.List;
import java.util.Map;

import kr.co.bit.vo.UserVo;

public interface UserDao {
	//insert의 value절에 들어감
	public boolean userInsert(Map<String,String> mParam);
	public boolean userUpdate(Map<String,String> mParam);
	public boolean userDelete(String mUserId);
	public List<UserVo> userSelect(Map<String,String> mParam);
	
}
