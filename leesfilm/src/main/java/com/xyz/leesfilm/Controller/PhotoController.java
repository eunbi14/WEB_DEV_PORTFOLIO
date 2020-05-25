package com.xyz.leesfilm.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyz.leesfilm.VO.PhotoVO;

@Controller
public class PhotoController {
private static final Logger logger=LoggerFactory.getLogger(PhotoController.class);
	

	@RequestMapping("/photoinsert")
	public String photoInsert(Model model) {
		PhotoVO photo = new PhotoVO("1.jpg","fleshes");
		logger.info("Photo Insert");
		model.addAttribute(photo);
		return "photoResult";
		//리턴 + jsp 파일로 모델 객체 리턴 
	}
	
	
}
