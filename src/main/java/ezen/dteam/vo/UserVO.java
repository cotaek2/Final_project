package ezen.dteam.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserVO extends User{//��ť��Ƽ���� ����� UserVOŬ���� ����, ������ User(��ť��Ƽ ����)
	
	//User�� ���°� �߰������� ����
	private String mid;
	private String mpw;
	private String mname;
	private String authority;

	//���ۻ����� ȣ��
	public UserVO(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,String authority, String mname) {//������ �Ű����� �߰�
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		//security���� �⺻������ �����ϴ� �� �ܿ� �ʿ��� �������� �߰�
		this.mid=username;
		this.mpw=password;
		this.authority=authority;
		this.mname=mname;	
	}

	//���ͼ���
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
	
}
