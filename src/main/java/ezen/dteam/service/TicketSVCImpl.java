package ezen.dteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ezen.dteam.dao.TicketDAO;
import ezen.dteam.vo.TheaterVO;

@Service
public class TicketSVCImpl implements TicketSVC{
	
	@Autowired
	TicketDAO ticketDAO;

	@Override
	public List<TheaterVO> selectTheater() {
		return ticketDAO.selectTheater();
	}
	
	
}
