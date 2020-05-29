package com.company.leesfilm;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Locale locale, Model model) {
		logger.debug("login page........");
		return "login";
	}
	
	@RequestMapping(value="/email", method=RequestMethod.POST)
	public String email(Locale locale, Model model) {
		logger.debug("email page.........");
		return "email";
	}
	
	@RequestMapping(value="/contact")
	public String about(Locale locale, Model model) {
		logger.debug("contact page.........");
		return "contact";
	}
	
	@RequestMapping(value="/logout")
	public String logout(Locale locale, Model model) {
		logger.debug("logout page.........");
		return "logout";
	}
	
	@RequestMapping(value="/upload")
	public String upload(Locale locale, Model model) {
		logger.debug("upload page.........");
		return "upload";
	}
	
	@RequestMapping(value="/editImage")
	public String edit(Locale locale, Model model) {
		logger.debug("editImage page.........");
		return "editImage";
	}
	
}
