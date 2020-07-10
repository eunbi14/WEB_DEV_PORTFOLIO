package com.xyz.leesfilm.DTO;

import org.springframework.stereotype.Component;

@Component
public class CategoryDTO {

	private String c_Category;
	private String p_Category;
	
	public String getC_Category() { return c_Category; }
	
	public String getP_Category() { return p_Category; }
	
}
