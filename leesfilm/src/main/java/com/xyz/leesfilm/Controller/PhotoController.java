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

import com.xyz.leesfilm.DAO.PhotoDAO;
import com.xyz.leesfilm.DTO.PhotoDTO;
import com.xyz.leesfilm.Service.PhotoService;

@Controller
public class PhotoController {
	private static final Logger logger=LoggerFactory.getLogger(PhotoController.class);
	
	List<String> resultList;
	
	@Inject
	private PhotoDAO photoDAO;
	private PhotoService photoService;
	
	@RequestMapping(value="/uploadphoto",method={RequestMethod.GET,RequestMethod.POST})
	public String uploadPhoto(Model model,
			@RequestParam("photofile") String photoUrl,
			@RequestParam("gugunSelect") String category) {
	//등록 버튼 눌렀을 때 db 에 업로드 하는 메소드 
	// url에서 id 부분만 떼서 db 에 저장 
		PhotoDTO photoDTO = new PhotoDTO();
		String url = photoUrl;
		logger.info(url);
		logger.info(category);
		String urlarr[] = url.split("/");
		String photo_name = urlarr[5];
		photoDTO.setP_Name(photo_name);
		photoDTO.setP_Category(category);
		photoDAO.insertPhoto(photoDTO);
		return "forward:/photoselect";
	}
	
	@RequestMapping(value= {"/photoselect","/photo"}, method={RequestMethod.GET,RequestMethod.POST})
	public String photo(Model model) {
		resultList= new ArrayList<String>();
		List<PhotoDTO> photoList = photoDAO.selectPhotoList();
		System.out.println("처음"+photoList.size());
		
		for(int i=0;i<photoList.size();i++) {
			System.out.println(resultList.size());
			if(resultList.contains(photoList.get(i).getP_Name())) {
				
				System.out.println(i+"번째 photolistname2:"+photoList.get(i).getP_Name());
				continue;
			}
			else {
			System.out.println(i+"번째 photolistname3:"+photoList.get(i).getP_Name());
			resultList.add(i, photoList.get(i).getP_Name());
			}
		}
		model.addAttribute("resultList",resultList);
		return "/photo";
	}
}
