package ezen.dteam.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ezen.dteam.vo.MemberVO;

@Repository
public class UserDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	private final String nameSpace = "ezen.dteam.mapper.userMapper";
	
	// 아이디 중복 검사
	public int checkId(String id) throws Exception{
		return sqlSession.selectOne(nameSpace+".checkId",id);
	}
	
	// 닉네임 중복 검사
	public int checkNickNm(String nickNm) throws Exception{
		return sqlSession.selectOne(nameSpace+".checkNickNm",nickNm);
	}
	
	// 이메일 중복 검사
	public int checkEmail(String email) throws Exception{
		return sqlSession.selectOne(nameSpace+".checkEmail",email);
	}
	
	//아이디 찾기
	public String searchId(MemberVO vo) throws Exception{
		return sqlSession.selectOne(nameSpace+".searchId",vo);
	}
}
