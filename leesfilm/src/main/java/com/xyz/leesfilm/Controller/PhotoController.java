package com.xyz.leesfilm.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.leesfilm.DAO.CommeDAO;
import com.xyz.leesfilm.DAO.PhotoDAO;
import com.xyz.leesfilm.DTO.CommeDTO;
import com.xyz.leesfilm.DTO.PhotoDTO;

@Controller
public class PhotoController {
	private static final Logger logger=LoggerFactory.getLogger(PhotoController.class);
	
	List<String> resultList;
	
	@Inject
	private PhotoDAO photoDAO;
	
	@Inject
	private CommeDAO commeDAO;
	
	Set<String> photoCategory;
	Set<String> comCategory;

	
	@RequestMapping(value="/uploadphoto",method={RequestMethod.GET,RequestMethod.POST})
	   public String uploadPhoto(Model model,
	         @RequestParam("photofile") String photoUrl,
	         @RequestParam("gugunSelect") String category,
	         HttpServletRequest request) {

	      PhotoDTO photoDTO = new PhotoDTO();
	      String url = photoUrl;
	      logger.info(category);
	      
	      String urlarr[] = url.split("/");
	      String photo_name = urlarr[5];
	      photoDTO.setP_Name(photo_name);
	      if(category.equals("�Һз� �߰�")) {
	         String addCate = request.getParameter("addCategory");
	         photoDTO.setP_Category(addCate);
	      }else {
	         photoDTO.setP_Category(category);
	      }
	      photoDAO.insertPhoto(photoDTO);
	      return "redirect:/photoselect";
	   }
	
	@RequestMapping(value= {"/photoselect","/photo"}, method={RequestMethod.GET,RequestMethod.POST})
	public String photo(Model model) {
		
		resultList= new ArrayList<String>();
		photoCategory = new HashSet<String>(); 
		comCategory = new HashSet<String>();
		List<PhotoDTO> photoList = photoDAO.selectPhotoList();
		List<CommeDTO> commeList = commeDAO.selectCommeList();
		
		for(int i=0;i<commeList.size();i++) {
			comCategory.add(commeList.get(i).getC_Category()); 
		}
		
		LinkedHashMap<String, String> photomap = new LinkedHashMap<String, String>();
		for(int i=0;i<photoList.size();i++) {
		
			photoCategory.add(photoList.get(i).getP_Category()); 
				/*
			if(photomap.containsValue(photoList.get(i).getP_Name())) {
				continue;
			}
			else {
				*/
			photomap.put(Integer.toString(photoList.get(i).getP_Id()), photoList.get(i).getP_Name());
			//}
		}
	
		model.addAttribute("resultMap",photomap);
		
		model.addAttribute("photoCategory", photoCategory);
		model.addAttribute("comCategory", comCategory);
		
		return "/photo";
	}
	
	@RequestMapping(value= {"/photo/{subvar}"}, method={RequestMethod.GET,RequestMethod.POST})
	public String photo(@PathVariable String subvar, Model model) {
		
		resultList= new ArrayList<String>();
		photoCategory = new HashSet<String>(); 
		comCategory = new HashSet<String>();
		List<PhotoDTO> photoList = photoDAO.selectPhotoList();
		List<CommeDTO> commeList = commeDAO.selectCommeList();
		
		for(int i=0;i<commeList.size();i++) {
			comCategory.add(commeList.get(i).getC_Category()); 
		}
		
		LinkedHashMap<String, String> photomap = new LinkedHashMap<String, String>();
		for(int i=0;i<photoList.size();i++) {
		
			photoCategory.add(photoList.get(i).getP_Category()); 
			
			if(photomap.containsValue(photoList.get(i).getP_Name())) {
				continue;
			}
			else if(photoList.get(i).getP_Category().equals(subvar)) {
				System.out.println(photoList.get(i).getP_Id());
			photomap.put(Integer.toString(photoList.get(i).getP_Id()), photoList.get(i).getP_Name());
			}
		}
	
		model.addAttribute("resultMap",photomap);
		
		model.addAttribute("photoCategory", photoCategory);
		model.addAttribute("comCategory", comCategory);
		
		return "/photo";
	}
	

	@RequestMapping(value="/deletephoto", method={RequestMethod.GET,RequestMethod.POST})
	public String deletePhoto(Model model, @RequestParam("photo_id")int photo_id) {
		System.out.println(photo_id);
		photoDAO.deletePhoto(photo_id);
		return "redirect:/photo";
	}
	
	@RequestMapping(value="/deletephotocategory",method={RequestMethod.POST})
	   public String deletePhotoCategory(Model model,
	         @RequestParam("gugunSelect") String category) {
	      PhotoDTO photoDTO = new PhotoDTO();
	      logger.info(category);
	      
	      photoDTO.setP_Category(category);
	      
	      photoDAO.deletePhotoCategory(photoDTO);
	      return "forward:/photoselect";
	   }
	
	@RequestMapping(value="/updatephoto", method={RequestMethod.GET,RequestMethod.POST})
	public String updatePhoto(Model model, 
			@RequestParam("photo_id")int photo_id,
			@RequestParam("photofile")String photo_real_name) {
		String urlarr[] = photo_real_name.split("/");
		String photo_name = urlarr[5];

		PhotoDTO photoDTO = new PhotoDTO();
		photoDTO.setP_Id(photo_id);
		photoDTO.setP_Name(photo_name);
		System.out.println(photoDTO.getP_Name());
		photoDAO.updatePhoto(photoDTO);

		return "redirect:/photo";
	}
}
