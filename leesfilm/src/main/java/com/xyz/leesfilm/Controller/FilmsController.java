package com.xyz.leesfilm.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.leesfilm.DAO.FilmsDAO;
import com.xyz.leesfilm.DTO.FilmsDTO;
import com.xyz.leesfilm.DTO.PhotoDTO;
import com.xyz.leesfilm.Service.FilmsService;

@Controller
public class FilmsController {
	private static final Logger logger=LoggerFactory.getLogger(FilmsController.class);
	
	@Inject
	private FilmsDAO filmsDAO;
	private FilmsService filmsService;
	
	List<String> resultList;
	
	@RequestMapping(value="/uploadFilms",method= {RequestMethod.GET,RequestMethod.POST})
	public String uploadVideo(Model model,
			@RequestParam("sidoSelect") String big_category,
			@RequestParam("gugunSelect") String category,
			@RequestParam("video_url") String videourl) {
			String video_id=videourl.substring(videourl.lastIndexOf("=")+1);
			System.out.println(video_id);	
			
			FilmsDTO filmsDTO = new FilmsDTO();
			filmsDTO.setF_Category("category1");
			filmsDTO.setF_Name(video_id);
			filmsDAO.insertFilms(filmsDTO);
			return "forward:/filmsselect";
		
	}
	
	@RequestMapping(value= {"/filmsselect","/films"}, method={RequestMethod.GET,RequestMethod.POST})
	public String photo(Model model) {
		resultList= new ArrayList<String>();
		List<FilmsDTO> filmsList = filmsDAO.selectFilmsList();
		System.out.println("처음"+filmsList.size());
		
		for(int i=0;i<filmsList.size();i++) {

			System.out.println(i+"번째 photolistname3:"+filmsList.get(i).getF_Name());
			resultList.add(i, filmsList.get(i).getF_Name());
			}
		model.addAttribute("resultList",resultList);
		return "/films";
	}
	
			
}
