package com.xyz.leesfilm.DTO;

import org.springframework.stereotype.Component;

@Component
public class PhotoDTO {
	int p_Id;
	String p_Category;
	String p_Name;
	String p_RealName;
	
	public int getP_Id() {
		return p_Id;
	}
	public void setP_Id(int p_Id) {
		this.p_Id = p_Id;
	}
	public String getP_Category() {
		return p_Category;
	}
	public void setP_Category(String p_Category) {
		this.p_Category = p_Category;
	}
	public String getP_Name() {
		return p_Name;
	}
	public void setP_Name(String p_Name) {
		this.p_Name = p_Name;
	}
	public String getP_RealName() {
		return p_RealName;
	}
	public void setP_RealName(String p_RealName) {
		this.p_RealName = p_RealName;
	}
}
