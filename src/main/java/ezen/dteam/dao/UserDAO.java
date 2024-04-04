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
	
	// ���̵� �ߺ�Ȯ��(ajax)
	public int checkId(String id) throws Exception{
		return sqlSession.selectOne(nameSpace+".checkId",id);
	}
	
	// �г��� �ߺ�Ȯ��(ajax)
	public int checkNickNm(String nickNm) throws Exception{
		return sqlSession.selectOne(nameSpace+".checkNickNm",nickNm);
	}
	
	// �̸��� �ߺ�Ȯ��(ajax)
	public int checkEmail(String email) throws Exception{
		return sqlSession.selectOne(nameSpace+".checkEmail",email);
	}
	
	//���̵� ã��(ajax)
	public String searchId(MemberVO vo) throws Exception{
		return sqlSession.selectOne(nameSpace+".searchId",vo);
	}
	
	//��й�ȣ ã��(ajax)
	public int updatePw(MemberVO vo) throws Exception{
		return sqlSession.update(nameSpace+".updatePw", vo);
	}

}
