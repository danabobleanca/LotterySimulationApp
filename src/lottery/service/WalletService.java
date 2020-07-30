package lottery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lottery.dao.WalletDao;
import lottery.model.Wallet;

@Service
public class WalletService {

	@Autowired
	WalletDao walletDao;
	
	public Boolean updateBalanceAfterDeposit(String email, Double deposit) {
		return walletDao.updateBalanceAfterDeposit(email, deposit);
	}
	public Boolean updateBalanceAfterWithdraw(String email, Double withdraw) {
		return walletDao.updateBalanceAfterWithdraw(email, withdraw);
	}
	
	public Boolean updateBalanceAfterWinning(String email, Double ticketWin) {
		return walletDao.updateBalanceAfterWinning(email, ticketWin);
	}
	
	public Wallet getBalanceObject(String email) {
		return walletDao.getBalanceObject(email);
	}
	
	public void saveObject(Wallet wallet){
		walletDao.saveObject(wallet);
	}
}
