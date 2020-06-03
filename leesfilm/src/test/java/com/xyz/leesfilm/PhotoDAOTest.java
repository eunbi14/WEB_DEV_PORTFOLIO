package com.xyz.leesfilm;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyz.leesfilm.DAO.PhotoDAO;
import com.xyz.leesfilm.DTO.PhotoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class PhotoDAOTest {
	
	@Inject
	private PhotoDAO dao;
	
	/*
	@Test
	public void testInsertPhoto() throws Exception{
		PhotoDTO vo = new PhotoDTO();
		vo.setPhotoId(2);
		vo.setPhotoFilename("photo_address.jpg");
		vo.setPhotoCategory("fleshes");
		dao.insertPhoto(vo);
	}
	*/
}
