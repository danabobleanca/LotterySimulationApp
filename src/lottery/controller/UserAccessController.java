package lottery.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lottery.model.Login;
import lottery.model.Ticket;
import lottery.model.UserRegister;
import lottery.service.LoginService;
import lottery.service.LottoSystemService;
import lottery.service.RegisterService;
import lottery.service.TicketService;

@Controller
public class UserAccessController {
	@Autowired
	LoginService loginService;
	@Autowired
	RegisterService registerService;
	@Autowired
	LottoSystemService lottoSystem;
	@Autowired
	TicketService ticketService;

	//display first user access page
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome() {
		return "index";
	}
	
	//display login page
	@RequestMapping(value="/loginPage", method=RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("loginDetails", new Login());
		return "loginPage";
	}
	
	//display welcome page if user is successfully login or display not  found user
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public ModelAndView successfulLogin(@Valid @ModelAttribute("loginDetails") Login loginDetails, BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("loginPage");
		}
		session.setAttribute("login", loginDetails);
		ModelAndView mv=new ModelAndView("welcome");
		Boolean loginStatus=loginService.getLoginDetails(loginDetails.getEmail(), loginDetails.getPassword());
		if(loginStatus) {
			//GENERATING SYSTEM NUMNERS
			//lottoSystem.saveNumbersGeneratedSystem();
			List<Ticket> listTickets=ticketService.getTicketsByEmail(loginDetails.getEmail());
			session.setAttribute("listTickets", listTickets);
			mv.addObject("listTickets", listTickets);
			return mv;
		}
		else{
			 mv=new ModelAndView("notFound");
		}
		return mv;
	}
	
	//display lotto page
	@RequestMapping(value="/loto", method=RequestMethod.GET)
	public String lotoPage(HttpSession session) {
		session.getAttribute("listTickets");
		return "welcome";
	}
	
	//display registration page
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String userRegistration(Model model) {
		model.addAttribute("registerDetails", new UserRegister());
		return "registerPage";
	}
	
	//register user to database and display the user details
	@RequestMapping(value="/registerState")
	public ModelAndView registrationStatus(@Valid @ModelAttribute("registerDetails") UserRegister register, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("registerPage");
		}
		Login login=new Login();
		login.setEmail(register.getLogin().getEmail());
		login.setPassword(register.getLogin().getPassword());
		UserRegister registerUser=new UserRegister(register.getName(), register.getCnp(), register.getAddress(), login);
		Boolean registerSuccess=registerService.saveUser(registerUser);
		ModelAndView mv=new ModelAndView("userDetails");
		if(registerSuccess) {
			mv.addObject("userDetails", register);
			return mv;
		}else {
			mv=new ModelAndView("registrationFailed");
		}
		return mv;
	}
	
	
}
