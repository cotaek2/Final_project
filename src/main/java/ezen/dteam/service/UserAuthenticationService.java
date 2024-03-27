package ezen.dteam.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ezen.dteam.vo.MemberVO;
import ezen.dteam.vo.UserVO;

//�Է��� �α��� ���̵�� ��ġ�ϴ� DB�� ���������� UserVO��ü�� ��ȯ
public class UserAuthenticationService implements UserDetailsService{

	SqlSession sqlSession;
	
	//������
	public UserAuthenticationService() {}
	public UserAuthenticationService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	//�߻�޼ҵ�
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//map���� (userMapper���� id��ȸ)
		MemberVO user
		=sqlSession.selectOne("ezen.dteam.mapper.userMapper.selectLogin",username);
	
		if(user == null) {
			System.out.println("user::"+user);
			//throw:������ ���ܹ߻�, throws:������ ���ܴ���
			throw new UsernameNotFoundException(username);
		}
		
		//list�� ��ȯ(authorities)
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		authority.add(new SimpleGrantedAuthority(user.getAuthority()));
		
		UserVO vo = new UserVO(user.getMid(),
								user.getMpw(),
								(Integer)Integer.valueOf(user.getEnabled())==1,
								true,
								true,
								true,
								authority,
								user.getAuthority(),
								user.getMname());
		
		return vo;
	}

}
