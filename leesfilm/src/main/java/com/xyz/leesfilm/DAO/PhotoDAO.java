package com.xyz.leesfilm.DAO;

import org.springframework.beans.factory.annotation.Autowired;

import com.xyz.leesfilm.VO.PhotoVO;

public interface PhotoDAO {

	public String getTime();
	public void insertPhoto(PhotoVO photoVO);
}
