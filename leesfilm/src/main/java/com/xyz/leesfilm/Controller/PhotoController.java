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
public class PhotoController {
private static final Logger logger=LoggerFactory.getLogger(PhotoController.class);
		
	@Inject
	private PhotoDAO photoDAO;
	private PhotoService photoService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value="/uploadphoto",method=RequestMethod.POST)
	public String uploadPhoto(MultipartHttpServletRequest req) {
		
		PhotoDTO dto = new PhotoDTO();
		MultipartFile mf = req.getFile("photofile");
		System.out.println(mf.getSize());
		String path = req.getSession().getServletContext().getRealPath("/");
		logger.info("path--------: "+path);
		String filename = mf.getOriginalFilename();
		File uploadFile = new File(path +"//"+ filename);
		
		try {
			mf.transferTo(uploadFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
		dto.setP_Category("fleshes");
		//카테고리 값들 디비에서 가져오기 
		//중복되는 파일이름 수정가능하게 uuid-> 유튜브 참고하기 
		dto.setP_Name(filename);
		dto.setP_RealName(filename);
		photoDAO.insertPhoto(dto);
		System.out.println(mf.getSize());
		
		System.out.println("photo insert success!, filename: "+ filename);
		return "home";
		
	}
}
