package com.xyz.leesfilm.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.xyz.leesfilm.DAO.PhotoDAO;
import com.xyz.leesfilm.DTO.PhotoDTO;
import com.xyz.leesfilm.Service.PhotoService;

@Controller
public class HomeController {
private static final Logger logger=LoggerFactory.getLogger(HomeController.class);
		
	@Inject
	private PhotoDAO photoDAO;
	private PhotoService photoService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/")
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
	public String upload(Locale locale, Model model)  {
		logger.debug("logout page.........");
		return "upload";
	}
	@RequestMapping(value="/editImage")
	public String edit(Locale locale, Model model) {
		logger.debug("editImage page.........");
		return "editImage";
	}
	
	@RequestMapping(value="/uploadAction")
	public String uploadAction(Locale locale, Model model) {
		logger.debug("uploadAction page.........");
		return "uploadAction";
	}
	
	@RequestMapping(value="/films")
	public String films(Locale locale, Model model) {
		logger.debug("films page.........");
		return "films";
	}
	
	@RequestMapping(value="/commercial")
	public String commercial(Locale locale, Model model) {
		logger.debug("commercial page.........");
		return "commercial";
	}
}