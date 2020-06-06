package com.xyz.leesfilm.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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

}
