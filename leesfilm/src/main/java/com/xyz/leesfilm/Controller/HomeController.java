package com.xyz.leesfilm.Controller;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xyz.leesfilm.DAO.CategoryDAO;
import com.xyz.leesfilm.DAO.HomepicDAO;
import com.xyz.leesfilm.DTO.CategoryDTO;
//import com.xyz.leesfilm.DTO.HomepicDTO;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private CategoryDAO categoryDAO;
//	private HomepicDAO homepicDAO;

	Set<String> photoCategory;
	Set<String> comCategory;
	
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		
		logger.info("Welcome home! The client locale {}.", locale);
		photoCategory = new HashSet<String>(); 
		comCategory = new HashSet<String>();
		List<CategoryDTO> categoryList = categoryDAO.selectCategoryList();
//		List<HomepicDTO> homepicList = homepicDAO.selectHomeList();
		
		for(int i=0;i<categoryList.size();i++) {
			comCategory.add(categoryList.get(i).getC_Category()); 
			photoCategory.add(categoryList.get(i).getP_Category()); 
		}
		
		/*
		 * LinkedHashMap<String, String> homepicmap = new LinkedHashMap<String,
		 * String>(); for(int i=0;i<homepicList.size();i++) {
		 * homepicmap.put(Integer.toString(homepicList.get(i).getH_Id()),
		 * homepicList.get(i).getH_name()); }
		 * 
		 * model.addAttribute("resultMap",homepicmap);
		 */
		model.addAttribute("photoCategory", photoCategory);
		model.addAttribute("comCategory", comCategory);
		
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Locale locale, Model model) {
		logger.debug("login page........");
		return "login";
	}

	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public String email(Locale locale, Model model) {
		logger.debug("email page.........");
		return "email";
	}

	@RequestMapping(value = "/contact")
	public String about(Locale locale, Model model) {
		logger.debug("contact page.........");
		photoCategory = new HashSet<String>(); 
		comCategory = new HashSet<String>();
		List<CategoryDTO> categoryList = categoryDAO.selectCategoryList();
			
		for(int i=0;i<categoryList.size();i++) {
			comCategory.add(categoryList.get(i).getC_Category()); 
			photoCategory.add(categoryList.get(i).getP_Category()); 
		}
		
		model.addAttribute("photoCategory", photoCategory);
		model.addAttribute("comCategory", comCategory);
		return "contact";
	}

	@RequestMapping(value = "/logout")
	public String logout(Locale locale, Model model) {
		logger.debug("logout page.........");
		return "logout";
	}

	@RequestMapping(value = "/upload")
	public String upload(Locale locale, Model model) {
		logger.debug("logout page.........");
		photoCategory = new HashSet<String>(); 
		comCategory = new HashSet<String>();
		List<CategoryDTO> categoryList = categoryDAO.selectCategoryList();
				
		for(int i=0;i<categoryList.size();i++) {
			comCategory.add(categoryList.get(i).getC_Category()); 
			photoCategory.add(categoryList.get(i).getP_Category()); 
		}
		model.addAttribute("photoCategory", photoCategory);
		model.addAttribute("comCategory", comCategory);
		return "upload";
	}

	@RequestMapping(value = "/editImage")
	public String edit(Locale locale, Model model) {
		logger.debug("editImage page.........");
		return "editImage";
	}
	
	@RequestMapping(value = "/mailSending")
	public String mailSending(Locale locale, Model model) {
		logger.debug("mailSending page.........");
		return "mailSending";
	}

}
