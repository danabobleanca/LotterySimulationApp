package lottery.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import lottery.model.Login;
import lottery.model.Wallet;

@Repository
public class WalletDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	public Wallet getBalanceObject(String email) {
		String query="SELECT w FROM Wallet w WHERE w.login.email=:email";
		List<Wallet> walletObj=(List<Wallet>) hibernateTemplate.findByNamedParam(query, "email", email);
		if(walletObj.size()>0) {
			return walletObj.get(0);
		}else {
			Wallet wallet=new Wallet();
			wallet.setBalance(0.00);
			return wallet;
		}	
	}
	
	public void saveObject(Wallet wallet){
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.save(wallet);
		tx.commit();
	}
	
	
	public Boolean updateBalanceAfterDeposit(String email, Double deposit) {
		Double balance=getBalanceObject(email).getBalance()+deposit;
		if(updateBalance(email,balance)) {
			return true;
		}else
			return false;
	}
	
	public Boolean updateBalanceAfterWithdraw(String email, Double withdraw) {
		Double balance=getBalanceObject(email).getBalance()-withdraw;
		if(updateBalance(email,balance)) {
			return true;
		}else
			return false;
	}
	
	public Boolean updateBalanceAfterWinning(String email, Double ticketWin) {
		Double balance=getBalanceObject(email).getBalance();
		balance+=ticketWin;
		if(updateBalance(email,balance)) {
			return true;
		}else
			return false;
	}
	
	 Boolean updateBalance(String email, Double balance) {
		Boolean success;
		Session session=hibernateTemplate.getSessionFactory().openSession();
		Query query=session.createQuery("UPDATE Wallet w SET w.balance=:balance WHERE w.login.email=:email");
		query.setParameter("email", email);
		query.setParameter("balance", balance);
		try {
			query.executeUpdate();
			session.getTransaction().commit();
			success=true;
		}catch(Exception e) {
			session.beginTransaction().rollback();
			e.printStackTrace();
			success=false;	
		}
		return success;
	}
	
}


