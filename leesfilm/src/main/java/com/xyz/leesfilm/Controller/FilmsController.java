package com.xyz.leesfilm.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.leesfilm.DAO.CategoryDAO;
import com.xyz.leesfilm.DAO.FilmsDAO;
import com.xyz.leesfilm.DTO.CategoryDTO;
import com.xyz.leesfilm.DTO.FilmsDTO;
import com.xyz.leesfilm.DTO.PhotoDTO;

@Controller
public class FilmsController {
	private static final Logger logger=LoggerFactory.getLogger(FilmsController.class);
	
	@Inject
	private FilmsDAO filmsDAO;
	
	@Inject
	private CategoryDAO categoryDAO;
	
	List<String> resultList;
	Set<String> comCategory;
	Set<String> photoCategory;
	
	
	@RequestMapping(value="/uploadFilms",method= {RequestMethod.GET,RequestMethod.POST})
	public String uploadVideo(Model model,
			@RequestParam("video_url") String videourl) {
		String film_name=videourl.substring(videourl.lastIndexOf("=")+1);	
			
		FilmsDTO filmsDTO = new FilmsDTO();
		filmsDTO.setF_Name(film_name);
		filmsDTO.setF_Category("category1");
		filmsDAO.insertFilms(filmsDTO);
		return "redirect:/filmsselect";
		
	}
	
	@RequestMapping(value= {"/filmsselect","/films"}, method={RequestMethod.GET,RequestMethod.POST})
	public String films(Model model) {
		resultList= new ArrayList<String>();
		comCategory = new HashSet<String>();
		photoCategory = new HashSet<String>();
		
		List<FilmsDTO> filmsList = filmsDAO.selectFilmsList();
		List<CategoryDTO> categoryList = categoryDAO.selectCategoryList();
		
		LinkedHashMap<String, String> filmmap = new LinkedHashMap<String, String>();
		for(int i=0;i<filmsList.size();i++) {
			filmmap.put(Integer.toString(filmsList.get(i).getF_Id()), filmsList.get(i).getF_Name());
		}
		
		for(int i=0;i<categoryList.size();i++) {
			comCategory.add(categoryList.get(i).getC_Category());  	
			photoCategory.add(categoryList.get(i).getP_Category()); 
		}
		
		model.addAttribute("resultFilmMap",filmmap);
		model.addAttribute("photoCategory", photoCategory);
		model.addAttribute("comCategory", comCategory);
		
		return "/films";
	}
	
	@RequestMapping(value="/deletefilm", method={RequestMethod.GET,RequestMethod.POST})
	public String deleteFilm(Model model, @RequestParam("film_id")int film_id) {
		System.out.println(film_id);
		filmsDAO.deleteFilms(film_id);
		return "redirect:/films";
	}

	@RequestMapping(value="/updatefilm", method={RequestMethod.GET,RequestMethod.POST})
	public String updateFilm(Model model, 
			@RequestParam("film_id")int film_id,
			@RequestParam("video_film_url")String film_real_name) {
		System.out.println("real name:"+ film_real_name);
		String film_name=film_real_name.substring(film_real_name.lastIndexOf("=")+1);
		System.out.println("film_name"+film_name);
		FilmsDTO filmsDTO = new FilmsDTO();
		filmsDTO.setF_Id(film_id);
		filmsDTO.setF_Name(film_name);
		filmsDAO.updateFilms(filmsDTO);
		return "redirect:/films";
	}
	
}
