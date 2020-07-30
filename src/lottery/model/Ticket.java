package lottery.model;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private ArrayList<Integer> chosenNumbers=new ArrayList<Integer>();
	private Integer totalChosenNumbers;
	private Double betAmount;
	private Double possibleWin;
	private Double totalWin;
	private Date dateOfExtraction;
	@Enumerated(EnumType.STRING)
	private TicketState ticketState;
	@ManyToOne
	private Login login;
	@ManyToOne
	private LottoSystem lottoSystem;
	
	
	public Ticket() {}
	
	public Ticket(ArrayList<Integer> chosenNumbers, Integer totalChosenNumbers, Double betAmount) {
		super();
		this.chosenNumbers = chosenNumbers;
		this.totalChosenNumbers = totalChosenNumbers;
		this.betAmount = betAmount;
	}
	public Integer getId() {
		return id;
	}
	
	public TicketState getTicketState() {
		return ticketState;
	}

	public void setTicketState(TicketState ticketState) {
		this.ticketState = ticketState;
	}
	
	public void setPossibleWin(Integer totalChosenNumbers, Double betAmount) {
		LottoSystem lotoSystem=new LottoSystem();
		this.possibleWin=lotoSystem.possibleWin(totalChosenNumbers, betAmount);
	}
	
	public void setTotalWin(Double totalWin) {
		this.totalWin=totalWin;
	}
	
	public Double getTotalWin() {
		return totalWin;
	}
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public ArrayList<Integer> getChosenNumbers() {
		return chosenNumbers;
	}

	public void setChosenNumbers(ArrayList<Integer> chosenNumbers) {
		this.chosenNumbers = chosenNumbers;
	}

	public Integer getTotalChosenNumbers() {
		return totalChosenNumbers;
	}
	public void setTotalChosenNumbers(Integer totalChosenNumbers) {
		this.totalChosenNumbers = totalChosenNumbers;
	}
	public Double getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(Double betAmount) {
		this.betAmount = betAmount;
	}

	public Double getPossibleWin() {
		return possibleWin;
	}
	public Date getDateOfExtraction() {
		return dateOfExtraction;
	}
	public void setDateOfExtraction(Date dateOfExtraction) {
		this.dateOfExtraction = dateOfExtraction;
	}

	public LottoSystem getLottoSystem() {
		return lottoSystem;
	}

	public void setLottoSystem(LottoSystem lottoSystem) {
		this.lottoSystem = lottoSystem;
	}
	
}
