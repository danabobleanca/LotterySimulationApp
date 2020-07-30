package lottery.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lottery.dao.TicketDao;
import lottery.model.Ticket;

@Service
public class TicketService {
	@Autowired
	TicketDao ticketDao;
	
	public Boolean saveTicket(Ticket ticket) {
		return ticketDao.saveTicket(ticket);
	}
	
	public List<Ticket> getTicketsByEmail(String email){
		return ticketDao.getTicketsByEmail(email);
	}
	
	public  List<Ticket> getTicketByUserAndDate(String email, Date dateExtraction){
		return ticketDao.getTicketByUserAndDate(email, dateExtraction);
	}
	
	public Double ticketWinning(Date systemDateExtraction, Ticket ticket, String email, Double bet) {
		return ticketDao.ticketWinning(systemDateExtraction, ticket, email,bet);
	}
	
}