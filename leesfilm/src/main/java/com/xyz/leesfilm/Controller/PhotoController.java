package com.xyz.leesfilm.Controller;

import java.io.File;
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

import com.xyz.leesfilm.DAO.PhotoDAO;
import com.xyz.leesfilm.DTO.PhotoDTO;
import com.xyz.leesfilm.Service.PhotoService;
import com.xyz.leesfilm.utils.UploadFileUtils;

@Controller
public class PhotoController {
private static final Logger logger=LoggerFactory.getLogger(PhotoController.class);
		
	@Inject
	private PhotoDAO photoDAO;
	private PhotoService photoService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
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
	public String upload(Locale locale, Model model)  {
		logger.debug("logout page.........");
		return "upload";
	}
	@RequestMapping(value="/photoupload")
	public String photoupload(PhotoDTO photoDTO, MultipartFile file) throws Exception{
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		photoDTO.setP_Name(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		photoDTO.setP_RealName(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		
		photoService.insertPhoto(photoDTO);
		return "redirect:/leesfilm/photo";
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
