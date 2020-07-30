package lottery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lottery.model.Login;
import lottery.model.Wallet;
import lottery.service.WalletService;

@Controller
public class WalletController {
	@Autowired
	WalletService walletService;

	@RequestMapping(value="/wallet", method=RequestMethod.GET)
	public ModelAndView walletBalance(ModelAndView mv, HttpSession session) {
		Login login=(Login) session.getAttribute("login");
		Wallet wallet=new Wallet();
		wallet.setLogin(login);
		Double balance=walletService.getBalanceObject(login.getEmail()).getBalance();
		mv.addObject("balance", balance);
		mv.setViewName("wallet");
		return mv;
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.GET)
	public ModelAndView deposit(ModelAndView mv) {
		mv.setViewName("deposit");
		return mv;
	}
	
	@RequestMapping(value="/paymentSuccess", method=RequestMethod.POST)
	public ModelAndView paymentSuccess(ModelAndView mv, HttpSession session, @RequestParam("amountDeposit") String amountDeposit) {
		Login login=(Login) session.getAttribute("login");
		Double amount=Double.parseDouble(amountDeposit);
		Wallet wallet=walletService.getBalanceObject(login.getEmail());
		if(wallet.getLogin()==null) {
			Wallet newWallet=new Wallet();
			newWallet.setLogin(login);
			newWallet.setBalance(amount);
			walletService.saveObject(newWallet);
		}else {
			walletService.updateBalanceAfterDeposit(login.getEmail(), amount);
		}
		mv.setViewName("paymentSuccess");
		return mv;
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.GET)
	public ModelAndView withraw(ModelAndView mv) {
		mv.setViewName("withdraw");
		return mv;
	}
	
	@RequestMapping(value="/withdrawSuccess", method=RequestMethod.POST)
	public ModelAndView withdrawSuccess(ModelAndView mv, HttpSession session, @RequestParam("amountWithdraw") Double withdraw) {
		Login login=(Login) session.getAttribute("login");
		Double balance=walletService.getBalanceObject(login.getEmail()).getBalance();
		if(withdraw>balance) {
			mv.setViewName("noFunds");
		}else {
			mv.setViewName("withdrawSuccess");
			walletService.updateBalanceAfterWithdraw(login.getEmail(), withdraw);
		}
		return mv;
	}
}
