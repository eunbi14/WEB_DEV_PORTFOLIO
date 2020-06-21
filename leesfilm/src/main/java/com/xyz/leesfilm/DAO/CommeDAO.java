package com.xyz.leesfilm.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.xyz.leesfilm.DTO.CommeDTO;

@Repository
public class CommeDAO {

	@Inject
	private SqlSession sqlSession;
	

	private static final String namespace="com.xyz.leesfilm.photoMapper";
	
	public int insertComme(CommeDTO commeDTO) {
		return sqlSession.insert(namespace+".insertComme", commeDTO);
		
	}
	public List<CommeDTO> selectCommeList() {
		return sqlSession.selectList(namespace+".selectCommeList");
	}
}
