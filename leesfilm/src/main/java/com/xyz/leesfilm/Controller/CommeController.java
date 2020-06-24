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

import com.xyz.leesfilm.DAO.CommeDAO;
import com.xyz.leesfilm.DTO.CommeDTO;
import com.xyz.leesfilm.Service.CommeService;

@Controller
public class CommeController {
	private static final Logger logger=LoggerFactory.getLogger(CommeController.class);
	
	@Inject
	private CommeDAO commeDAO;
	private CommeService commeService;

	
	List<String> resultList;
	
	@RequestMapping(value="/uploadCommercial",method={RequestMethod.GET,RequestMethod.POST})
	public String uploadVideo(Model model,
			@RequestParam("sidoSelect") String big_category,
			@RequestParam("gugunSelect") String category,
			@RequestParam("video_url") String videourl) {
		
			String video_id=videourl.substring(videourl.lastIndexOf("=")+1);
			System.out.println(video_id);	
			
			CommeDTO commeDTO = new CommeDTO();
			commeDTO.setC_Category("comme1");
			commeDTO.setC_Name(video_id);
			commeDAO.insertComme(commeDTO);
			return "forward:/commeselect";
	}
	
	@RequestMapping(value= {"/commeselect","/commercial"}, method={RequestMethod.GET,RequestMethod.POST})
	public String photo(Model model) {
		resultList= new ArrayList<String>();
		List<CommeDTO> commeList = commeDAO.selectCommeList();
		for(int i=0;i<commeList.size();i++) {
			System.out.println(i+"번째 photolistname3:"+commeList.get(i).getC_Name());
			resultList.add(i, commeList.get(i).getC_Name());
			}
		model.addAttribute("resultList",resultList);
		return "/commercial";
	}
	
			
}
