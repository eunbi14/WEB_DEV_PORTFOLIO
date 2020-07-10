package com.xyz.leesfilm.Controller;

import java.util.ArrayList;
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
import com.xyz.leesfilm.DTO.FilmsDTO;
import com.xyz.leesfilm.DTO.PhotoDTO;

@Controller
public class CommeController {
	private static final Logger logger=LoggerFactory.getLogger(CommeController.class);
	
	@Inject
	private CommeDAO commeDAO;
	
	@Inject
	private PhotoDAO photoDAO;

	Set<String> comCategory;
	Set<String> photoCategory;
	List<String> resultList;
	
	@RequestMapping(value="/uploadCommercial",method={RequestMethod.GET,RequestMethod.POST})
	   public String uploadVideo(Model model,
	         @RequestParam("video_url") String videourl,
	         @RequestParam("gugunSelect") String category,
	         HttpServletRequest request) {
	         
	      CommeDTO commeDTO = new CommeDTO();
	      String video_id=videourl.substring(videourl.lastIndexOf("=")+1);
	      
	      commeDTO.setC_Name(video_id);
	      if(category.equals("소분류 추가")) {
	         String addCate = request.getParameter("addCategory");
	         commeDTO.setC_Category(addCate);
	      }else {
	         commeDTO.setC_Category(category);
	      }
	      commeDAO.insertComme(commeDTO);
	      return "redirect:/commeselect";
	   }
	
	@RequestMapping(value= {"/commeselect","/commercial"}, method={RequestMethod.GET,RequestMethod.POST})
	public String photo(Model model) {
		resultList= new ArrayList<String>();
		comCategory = new HashSet<String>(); 
		photoCategory = new HashSet<String>(); 
	
		List<PhotoDTO> photoList = photoDAO.selectPhotoList();
		List<CommeDTO> commeList = commeDAO.selectCommeList();
		
		LinkedHashMap<String, String> commemap = new LinkedHashMap<String, String>();
		for(int i=0;i<commeList.size();i++) {
			comCategory.add(commeList.get(i).getC_Category()); 
			commemap.put(Integer.toString(commeList.get(i).getC_Id()), commeList.get(i).getC_Name());
		}
		
		for(int i=0;i<photoList.size();i++) {
			photoCategory.add(photoList.get(i).getP_Category()); 
		}
		model.addAttribute("resultCommeMap",commemap);
		model.addAttribute("comCategory", comCategory);
		model.addAttribute("photoCategory", photoCategory);
		return "/commercial";		
	}
	
	   @RequestMapping(value= {"/commercial/{subvar}"}, method={RequestMethod.GET,RequestMethod.POST})
	   public String photo(@PathVariable String subvar, Model model) {
	      resultList= new ArrayList<String>();
	      comCategory = new HashSet<String>(); 
	      photoCategory = new HashSet<String>(); 
	   
	      List<PhotoDTO> photoList = photoDAO.selectPhotoList();
	      List<CommeDTO> commeList = commeDAO.selectCommeList();
	      
	      for(int i=0;i<photoList.size();i++) {
	         
	         photoCategory.add(photoList.get(i).getP_Category()); 
	      }
	      
	      LinkedHashMap<String, String> commemap = new LinkedHashMap<String, String>();
	      for(int i=0;i<commeList.size();i++) {
	      
	         comCategory.add(commeList.get(i).getC_Category()); 
	         if(commeList.get(i).getC_Category().equals(subvar)) {
	            commemap.put(Integer.toString(commeList.get(i).getC_Id()), commeList.get(i).getC_Name());
	         }
	      }
	      
	      model.addAttribute("resultCommeMap",commemap);
	      model.addAttribute("comCategory", comCategory);
	      model.addAttribute("photoCategory", photoCategory);
	      return "/commercial";
	      
	   }

	
	@RequestMapping(value="/deletecommecategory",method={RequestMethod.POST})
	   public String deleteCommeCategory(Model model,
	         @RequestParam("gugunSelect") String category) {
	      CommeDTO commeDTO = new CommeDTO();
	      logger.info(category);
	      
	      commeDTO.setC_Category(category);
	      
	      commeDAO.deleteCommeCategory(commeDTO);
	      return "forward:/commeselect";
	   }
	
	@RequestMapping(value="/deletecomme", method={RequestMethod.GET,RequestMethod.POST})
	public String deleteComme(Model model, @RequestParam("comme_id")int comme_id) {
		commeDAO.deleteComme(comme_id);
		return "redirect:/commercial";
	}

	@RequestMapping(value="/updatecomme", method={RequestMethod.GET,RequestMethod.POST})
	public String updateFilm(Model model, 
			@RequestParam("comme_id")int comme_id,
			@RequestParam("video_comme_url")String comme_real_name) {
		//System.out.println("real name:"+ comme_real_name);
		String comme_name=comme_real_name.substring(comme_real_name.lastIndexOf("=")+1);
		//System.out.println("film_name"+comme_name);
		CommeDTO commeDTO = new CommeDTO();
		commeDTO.setC_Id(comme_id);
		commeDTO.setC_Name(comme_name);
		commeDAO.updateComme(commeDTO);
		return "redirect:/commercial";
	}

}
