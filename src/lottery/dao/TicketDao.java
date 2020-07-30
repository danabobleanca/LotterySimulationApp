package lottery.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import lottery.model.LottoSystem;
import lottery.model.Ticket;
import lottery.model.TicketState;
import lottery.model.UserRegister;

@Repository
public class TicketDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	LottoSystemDao lottoSystemDao;
	
	public Boolean saveTicket(Ticket ticket) {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Boolean save;
		try {
			session.persist(ticket);
			tx.commit();
			save=true;
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			save=false;
		}
		return save;
		
	}
	
	public List<Ticket> getTicketsByEmail(String email){
		String query="SELECT t from Ticket t WHERE t.login.email=:email";
		List<Ticket> tickets=(List<Ticket>) hibernateTemplate.findByNamedParam(query, "email",email);
		if(tickets.size()>0) {
			return tickets;
		}else {
			return null;
		}
	}
	
	public List<Ticket> getTicketByUserAndDate(String email, java.sql.Date dateExtraction) {
		String query="SELECT t from Ticket t WHERE t.login.email=:email AND t.dateOfExtraction=:extraction";
		List<Ticket> ticketsByDate=(List<Ticket>) hibernateTemplate.findByNamedParam(query, new String[] {"email", "extraction"},new Object[] {email, dateExtraction});
		if(ticketsByDate.size()>0) {
			return ticketsByDate;
		}else {
			return null;
		}
	}
	
	public Double ticketWinning(Date systemDateExtraction, Ticket t, String email, Double bet) {
		Double totalWinning=0.00;
		LottoSystem lottoSystem=lottoSystemDao.getLottoSystemObject(systemDateExtraction);
	
			if(t.getDateOfExtraction().equals(lottoSystem.getDateOfExtraction())) {
				for(int i=0;i<t.getChosenNumbers().size();i++) {
						if(lottoSystem.systemGeneratedNumbers().contains(t.getChosenNumbers().get(i))) {
							totalWinning=lottoSystem.possibleWin(t.getTotalChosenNumbers(), bet);
							t.setTicketState(TicketState.WINNER);
						}else {
							t.setTicketState(TicketState.NOT_WINNER);
							totalWinning=0.00;
						}
				}
			}else {
				totalWinning=0.00;
			}
		return totalWinning;
	}
	
}
