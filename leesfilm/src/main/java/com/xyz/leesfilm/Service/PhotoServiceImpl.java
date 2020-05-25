package com.xyz.leesfilm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.leesfilm.DAO.PhotoDAO;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	PhotoDAO photoDAO;

	@Override
	public int photoInsert(PhotoDAO photo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
