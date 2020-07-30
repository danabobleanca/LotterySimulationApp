package lottery.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.Session;

@Entity
public class LottoSystem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Date dateOfExtraction;
	private ArrayList<Integer> systemGeneratedNumbers=new ArrayList<Integer>();
	@OneToMany(mappedBy="lottoSystem")
	private List<Ticket> ticketList;
	
	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public LottoSystem() {
		super();
	}

	public ArrayList<Integer> systemGeneratedNumbers() {
		while(systemGeneratedNumbers.size()<11) {
			Random random=new Random();
			Integer a=random.nextInt(20)+1;
			if(!systemGeneratedNumbers.contains(a)) {
				systemGeneratedNumbers.add(a);
			}
		}
		return systemGeneratedNumbers;
	}
	

	public void setSystemGeneratedNumbers(ArrayList<Integer> systemGeneratedNumbers) {
		this.systemGeneratedNumbers = systemGeneratedNumbers;
	}

	public Double possibleWin(Integer totalNumbersSelected, Double bet) {
		Double possibleWin;
		switch(totalNumbersSelected) {
			case 1:
				possibleWin=QuotaLotto10From20.ONE_NUMBER.getQuotaLotto()*bet;
				break;
			case 2:
				possibleWin=QuotaLotto10From20.TWO_NUMBERS.getQuotaLotto()*bet;
				break;
			case 3:
				possibleWin=QuotaLotto10From20.THREE_NUMBERS.getQuotaLotto()*bet;
				break;
			case 4:
				possibleWin=QuotaLotto10From20.FOUR_NUMBERS.getQuotaLotto()*bet;
				break;
			case 5:
				possibleWin=QuotaLotto10From20.FIVE_NUMBERS.getQuotaLotto()*bet;
				break;
			case 6:
				possibleWin=QuotaLotto10From20.SIX_NUMBERS.getQuotaLotto()*bet;
				break;
			case 7:
				possibleWin=QuotaLotto10From20.SEVEN_NUMBERS.getQuotaLotto()*bet;
				break;
			case 8:
				possibleWin=QuotaLotto10From20.EIGHT_NUMEBRS.getQuotaLotto()*bet;
				break;
			case 9:
				possibleWin=QuotaLotto10From20.NINE_NUMBERS.getQuotaLotto()*bet;
				break;
			case 10:
				possibleWin=QuotaLotto10From20.TEN_NUMEBRS.getQuotaLotto()*bet;
				break;
			default:
				possibleWin=0.00;
		}
		return possibleWin;	
	}

	public Date getDateOfExtraction() {
		return dateOfExtraction;
	}

	public ArrayList<Integer> getSystemGeneratedNumbers() {
		return systemGeneratedNumbers;
	}

	public void setDateOfExtraction(Date dateOfExtraction) {
		this.dateOfExtraction = dateOfExtraction;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	
}
