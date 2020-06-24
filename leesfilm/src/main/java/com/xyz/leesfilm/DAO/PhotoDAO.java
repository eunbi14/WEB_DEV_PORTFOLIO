package com.xyz.leesfilm.DAO;

import java.util.List;
import java.util.Map;

import com.xyz.leesfilm.DTO.PhotoDTO;

public interface PhotoDAO {

	public int insertPhoto(PhotoDTO photoDTO);
	public List<PhotoDTO> selectPhotoList();
}
