package com.xyz.leesfilm.DAO;

import java.util.List;
import java.util.HashMap;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.xyz.leesfilm.DTO.PhotoDTO;

@Repository
public class PhotoDAOImpl implements PhotoDAO {

   @Inject
   private SqlSession sqlSession;
   

   private static final String namespace="com.xyz.leesfilm.photoMapper";
   
   @Override
   public int insertPhoto(PhotoDTO photoDTO) {
      return sqlSession.insert(namespace+".insertPhoto", photoDTO);
   }

   @Override
   public List<PhotoDTO> selectPhotoList() {
      return sqlSession.selectList(namespace+".selectPhotoList");
   }
   
   @Override
   public int deletePhotoCategory(PhotoDTO photoDTO) {
      return sqlSession.delete(namespace+".deletePhotoCategory", photoDTO);
   }
   
   public int deletePhoto(int photo_id) {
		return sqlSession.delete(namespace+".deletePhoto",photo_id);
	}

	@Override
	public int updatePhoto(PhotoDTO photoDTO) {
		return sqlSession.update(namespace+".updatePhoto",photoDTO);
	}

}