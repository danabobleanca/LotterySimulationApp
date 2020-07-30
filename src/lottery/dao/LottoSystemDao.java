package lottery.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import lottery.model.LottoSystem;

@Repository
public class LottoSystemDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//LottoSystem lottoSystem=new LottoSystem();
	
	public void saveNumbersGeneratedSystem() {
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		LottoSystem lotto;
		Integer currentYear=2020;
		Integer currentMonth=6;
		Integer currentDay=0;
		Integer id=0;
		Calendar calendar=GregorianCalendar.getInstance();
		for(int i=0;i<365;i++) {
			lotto=new LottoSystem();
			if(currentDay>30) {
				currentDay=1;
				currentMonth++;
			}
			if(currentMonth>11) {
				currentMonth=1;
				currentYear++;
			}
			
			if(currentDay==5 || currentDay==12 || currentDay==19 || currentDay == 26) {
				calendar.set(Calendar.YEAR, currentYear);
				calendar.set(Calendar.MONTH, currentMonth);
				calendar.set(Calendar.DAY_OF_MONTH, currentDay);
				java.util.Date date=calendar.getTime();
				java.sql.Date dateConverted=new java.sql.Date(date.getTime());
				lotto.setId(++id);
				lotto.setSystemGeneratedNumbers(lotto.systemGeneratedNumbers());
				lotto.setDateOfExtraction(dateConverted);
				session.save(lotto);
			
			}
			++currentDay;
		}
		tx.commit();
	}

	public LottoSystem getLottoSystemObject(Date systemDateExtraction) {
		String query="SELECT ls FROM LottoSystem ls WHERE ls.dateOfExtraction=:dateOfExtraction";
		List<LottoSystem> lottoNumbers=(List<LottoSystem>) hibernateTemplate.findByNamedParam(query, "dateOfExtraction", systemDateExtraction);
		if(lottoNumbers.size()>0){
			return lottoNumbers.get(0);
		}else
			return null;
	}

	
}
