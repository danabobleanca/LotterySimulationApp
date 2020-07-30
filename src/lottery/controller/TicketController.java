package lottery.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import lottery.model.Login;
import lottery.model.LottoSystem;
import lottery.model.Ticket;
import lottery.service.LottoSystemService;
import lottery.service.RegisterService;
import lottery.service.TicketService;
import lottery.service.WalletService;

@Controller
public class TicketController {

	@Autowired
	TicketService ticketService;
	@Autowired
	RegisterService registerService;
	@Autowired
	LottoSystemService lottoSystemService;
	@Autowired
	WalletService walletService;
	
	@RequestMapping(value="/createTicket", method=RequestMethod.GET)
	public ModelAndView lottoNumbers(ModelAndView mv,HttpSession session, @RequestParam(value="lottoNumbers", required=false) String[] lottoNumbers) {
		Arrays.toString(lottoNumbers);
		session.setAttribute("chosenNumbers", lottoNumbers);
		mv.setViewName("createTicket");
		mv.addObject("chosenNumbers", lottoNumbers);
		return mv;
	}
	
	@RequestMapping(value="/ticketCreated", method=RequestMethod.POST)
	public ModelAndView ticketDetails(ModelAndView mv,HttpSession session, @RequestParam("bet") Double bet ,@RequestParam("dateOfExtraction") String extraction) throws ParseException {
		String[] chosenNumbers=(String[]) session.getAttribute("chosenNumbers");
		Integer [] lottoNo=new Integer[chosenNumbers.length];
		for(int i=0;i<chosenNumbers.length;i++) {
			lottoNo[i]=Integer.parseInt(chosenNumbers[i]);
		}
		ArrayList<Integer> userNumbers=new ArrayList<>(Arrays.asList(lottoNo));
		Login login=(Login) session.getAttribute("login");
		Double balance=walletService.getBalanceObject(login.getEmail()).getBalance();
		if(bet>balance) {
			mv.setViewName("noFunds");
		}else {
			walletService.updateBalanceAfterWithdraw(login.getEmail(), bet);
			Ticket ticket=new Ticket(userNumbers, userNumbers.size(), bet);
			ticket.setLogin(login);
			ticket.setPossibleWin(userNumbers.size(), bet);
			
			//date of extraction
			Date dateExtraction=new SimpleDateFormat("dd-MM-yyyy").parse(extraction);
			java.sql.Date dExtraction=new java.sql.Date(dateExtraction.getTime());
			ticket.setDateOfExtraction(dExtraction);
			session.setAttribute("dExtraction", dExtraction);
			Double totalWin=ticketService.ticketWinning(dExtraction, ticket, login.getEmail(), bet);
			ticket.setTotalWin(totalWin);
			if(totalWin>0.00) {
				walletService.updateBalanceAfterWinning(login.getEmail(), totalWin);
			}
			LottoSystem lottoSystem=lottoSystemService.getLottoSystemObject(dExtraction);
			ticket.setLottoSystem(lottoSystem);
			//saving to database
			ticketService.saveTicket(ticket);
			mv.addObject("possibleWin",ticket.getPossibleWin());
			mv.addObject("bet", bet);
			mv.addObject("lottoNo", lottoNo);
			mv.addObject("dateOfExtraction", extraction);
			mv.addObject("chosenTotalNumbers", lottoNo.length );
			mv.setViewName("ticketCreated");
		}
		return mv;
	}
	
	@RequestMapping(value="/tickets", method=RequestMethod.GET)
	public ModelAndView tickets(ModelAndView mv, HttpSession session) {
		mv.setViewName("tickets");
		Login login=(Login) session.getAttribute("login");
		List<Ticket> tickets=ticketService.getTicketsByEmail(login.getEmail());
		mv.addObject("tickets", tickets);
		return mv;
	}
}
