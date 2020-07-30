package lottery.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lottery.dao.LottoSystemDao;
import lottery.model.LottoSystem;

@Service
public class LottoSystemService {

	@Autowired
	LottoSystemDao lottoDao;
	
	public void saveNumbersGeneratedSystem() {
		lottoDao.saveNumbersGeneratedSystem();
	}
	
	public LottoSystem getLottoSystemObject(Date systemDateExtraction) {
		return lottoDao.getLottoSystemObject(systemDateExtraction);
	}
}
