package ezen.dteam.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ezen.dteam.dao.admInquiryDAO;
import ezen.dteam.dao.admNoticeDAO;
import ezen.dteam.vo.BoardVO;
import ezen.dteam.vo.PagingVO;
import ezen.dteam.vo.UserVO;

@RequestMapping(value = "/admin/notice")
@Controller
public class AdmNotice {
	
	@Autowired
	admNoticeDAO admNoticeDAO;
	
	@Autowired
	admInquiryDAO admInquiryDAO;
	
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public String noticeList(Model model, String nowPageParam) {
		
		int nowPage = 1;
		if(nowPageParam != null && !nowPageParam.equals("")){
			nowPage = Integer.parseInt(nowPageParam);
		}
		
		int totalCnt = admNoticeDAO.selectBoardAllCnt();
		
		PagingVO pagingVO = new PagingVO(nowPage, totalCnt, 2);
		
		model.addAttribute("pagingVO", pagingVO);
		
		model.addAttribute("board", admNoticeDAO.selectBoardAll(pagingVO));
		
		return "/admin/notice/noticeList";
	}
	
	@RequestMapping(value = "/noticeView", method = RequestMethod.GET)
	public String noticeView(Model model, String bno) {
		model.addAttribute("boardVO",admNoticeDAO.selectBoardBno(bno));
		return "/admin/notice/noticeView";
	}
	
	
	
	
	@RequestMapping(value = "/noticeWrite", method = RequestMethod.GET)
	public String noticeWrite() {
		return "/admin/notice/noticeWrite";
	}
	
	@RequestMapping(value = "/noticeWrite", method = RequestMethod.POST)
	public void noticeWriteOk(Authentication authentication, HttpServletResponse response, String btitle, String bcontent) throws IOException {
		UserVO loginUser = (UserVO)authentication.getPrincipal();
		
		String mid = loginUser.getMid();
		int mno = admInquiryDAO.midtomno(mid);
		
		BoardVO boardVO = new BoardVO(btitle, bcontent, mno);
		
		int result = admNoticeDAO.insertNotice(boardVO);
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		if(result>0) {
			response.getWriter().append("<script>alert('������ �ۼ��߽��ϴ�.');location.href='noticeList';</script>");
		}else {
			response.getWriter().append("<script>alert('������ �ۼ����� �ʾҽ��ϴ�.');location.href='noticeList';</script>");			
		}
		response.getWriter().flush();
	}
	
	
	
	
	@RequestMapping(value = "/noticeModify", method = RequestMethod.GET)
	public String noticeModify() {
		
		return "/admin/notice/noticeModify";
	}
	
	@RequestMapping(value = "/noticeModify", method = RequestMethod.POST)
	public String noticeModifyOk() {
		
		return "redirect:/";
	}
	
	
	
}
