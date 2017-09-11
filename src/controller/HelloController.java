package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.TransactionSummary;
import service.Loader;

/**
 * Servlet implementation class HelloController
 */
@Controller
public class HelloController  {
	private static final long serialVersionUID = 1L;
       


	@RequestMapping("/welcome")
	protected ModelAndView helloWorld() {
	
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		Loader loader = new Loader();

		TransactionSummary transactionSummary = loader.process();
		modelAndView.addObject("transactionSummary", transactionSummary);

		modelAndView.addObject("welcomeMessage", "hello");
		
		
		return modelAndView;
	}

	@RequestMapping("/report")
	protected ModelAndView report() {
	
		ModelAndView modelAndView = new ModelAndView("dashboard");
		Loader loader = new Loader();
		TransactionSummary transactionSummary = loader.process();
		modelAndView.addObject("welcomeMessage", "hello");
		modelAndView.addObject("transactionSummary", transactionSummary);

		
		
		return modelAndView;
	}
	@RequestMapping("/table")
	protected ModelAndView table() {
	
		ModelAndView modelAndView = new ModelAndView("table");
		Loader loader = new Loader();
		TransactionSummary transactionSummary = loader.process();
		modelAndView.addObject("welcomeMessage", "hello");
		modelAndView.addObject("transactionSummary", transactionSummary);

		
		
		return modelAndView;
	}
	
}
