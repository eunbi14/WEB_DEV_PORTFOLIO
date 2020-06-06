package com.xyz.leesfilm.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.xyz.leesfilm.DAO.PhotoDAO;
import com.xyz.leesfilm.DTO.PhotoDTO;

@Service("PhotoService")
public class PhotoServiceImpl implements PhotoService {

	@Inject
	private PhotoDAO photoDAO;

	@Override
	public PhotoDTO insertPhoto(PhotoDTO photoDTO) {
		 photoDAO.insertPhoto(photoDTO);
		 return photoDTO;
	}

}
