package com.xyz.leesfilm.Controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
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
	public String uploadPhoto(MultipartHttpServletRequest req) throws Exception {
		
		PhotoDTO dto = new PhotoDTO();
		MultipartFile photofile = req.getFile("photofile");
		System.out.println(photofile.getSize());
		//String path = req.getSession().getServletContext().getRealPath("/");

		String p_realName = photofile.getOriginalFilename();
		String p_name = uploadPhotoFile(photofile);
		File uploadFile = new File(uploadPath +"//"+ p_name);
		
		try {
			photofile.transferTo(uploadFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
		dto.setP_Category("fleshes");
		dto.setP_Name(p_name);
		dto.setP_RealName(p_realName);
		photoDAO.insertPhoto(dto);
		System.out.println(photofile.getSize());
		System.out.println("photo insert success!, filename: "+ p_realName);
		return "photo";
		
	}
	private String uploadPhotoFile(MultipartFile photofile) throws Exception {
		String savedPhotoFileName = UUID.randomUUID().toString()+"_"
				+ photofile.getOriginalFilename();
		return savedPhotoFileName;
	}

}
