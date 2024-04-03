package ezen.dteam.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ezen.dteam.service.UserSVCImpl;
import ezen.dteam.vo.MemberVO;

//@RequestMapping(value="/user")
@Controller
public class User {
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserSVCImpl service;
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return "user/login";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		
		return "user/join";
	}
	
	//아이디 중복확인(ajax)
	@ResponseBody
	@RequestMapping(value="/checkId", method=RequestMethod.POST)
	public String checkId(String id) throws Exception {
		return Integer.toString(service.checkId(id));
	}
	
	//닉네임 중복확인(ajax)
	@ResponseBody
	@RequestMapping(value="/checkNickNm", method=RequestMethod.POST)
	public String checkNickNm(String nickNm) throws Exception {
		return Integer.toString(service.checkNickNm(nickNm));
	}
	
	//이메일 중복확인(ajax)
	@ResponseBody
	@RequestMapping(value="/checkEmail", method=RequestMethod.POST)
	public String checkEmail(String email) throws Exception {
		return Integer.toString(service.checkEmail(email));
	}
	
	//회원가입
	@RequestMapping(value="/joinOk", method=RequestMethod.POST)
	public String joinOk(String mid,String mpw, String mname,String authority, String enabled,
			String mnickNm, String mbirth, String memail,String mgender, String mphone) {
		
		//BCrypt 암호화
		BCryptPasswordEncoder epwe = new BCryptPasswordEncoder();
		
		Map<String,Object> vo = new HashMap<String,Object>();
		vo.put("mid", mid);
		vo.put("mpw",epwe.encode(mpw));
		vo.put("mname", mname);
		vo.put("mnickNm", mnickNm);
		vo.put("mbirth", mbirth);
		vo.put("memail", memail);
		vo.put("mphone", mphone);
		vo.put("mgender", mgender);		
		vo.put("enabled", enabled);		
		vo.put("authority", authority);
		
		//db에 insert
		int result = sqlSession.insert("ezen.dteam.mapper.userMapper.insert",vo);
		
		return "redirect:/user/login";
	}
	
	
	@RequestMapping(value = "/findId", method = RequestMethod.GET)
	public String findId() throws Exception{
		
		return "user/findId";
	}
	//아이디 찾기(ajax)
	@ResponseBody
	@RequestMapping(value = "/searchId", method = RequestMethod.POST)
	public String searchId(MemberVO vo) throws Exception{
		
		return service.searchId(vo);
		
	}
	@RequestMapping(value = "/findPw", method = RequestMethod.GET)
	public String findPw() throws Exception{
		
		return "user/findPw";
	}
	
}
