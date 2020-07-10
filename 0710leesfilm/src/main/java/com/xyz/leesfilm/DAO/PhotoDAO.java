package com.xyz.leesfilm.DAO;

import java.util.List;
import java.util.HashMap;

import com.xyz.leesfilm.DTO.PhotoDTO;

public interface PhotoDAO {

   public int insertPhoto(PhotoDTO photoDTO);
   public List<PhotoDTO> selectPhotoList();
   public int deletePhotoCategory(PhotoDTO photoDTO);
   public int deletePhoto(int photo_id);
   public int updatePhoto(PhotoDTO photoDTO);
}