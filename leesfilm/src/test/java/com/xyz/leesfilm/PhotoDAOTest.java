package com.xyz.leesfilm;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyz.leesfilm.DAO.PhotoDAO;
import com.xyz.leesfilm.VO.PhotoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class PhotoDAOTest {
	
	@Inject
	private PhotoDAO dao;
	
	@Test
	public void testTime() throws Exception{
		System.out.println(dao.getTime());
	}
	@Test
	public void testInsertPhoto() throws Exception{
		PhotoVO vo = new PhotoVO();
		vo.setPhotoId(2);
		vo.setPhotoAddr("photo_address.jpg");
		vo.setPhotoCategory("fleshes");
		dao.insertPhoto(vo);
	}
}
