package com.xyz.leesfilm.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xyz.leesfilm.VO.PhotoVO;

@Repository
public class PhotoDAOImpl implements PhotoDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.xyz.leesfilm.photoMapper";
	
	@Override
	public void insertPhoto(PhotoVO photoVO) {
		sqlSession.insert(namespace+".insertPhoto", photoVO);

	}

	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}

}
