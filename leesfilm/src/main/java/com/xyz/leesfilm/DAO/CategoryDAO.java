package com.xyz.leesfilm.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.xyz.leesfilm.DTO.CategoryDTO;

@Repository
public class CategoryDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.xyz.leesfilm.photoMapper";
	
	public List<CategoryDTO> selectCategoryList() {
		return sqlSession.selectList(namespace+".selectCategoryList");
	}
}