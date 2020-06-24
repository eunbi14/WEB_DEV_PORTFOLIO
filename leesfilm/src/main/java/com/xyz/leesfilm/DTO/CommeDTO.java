package com.xyz.leesfilm.DTO;

import org.springframework.stereotype.Component;

@Component
public class CommeDTO {

	private int c_Id;
	private String c_Category;
	private String c_Name;
	
	public int getC_Id() {
		return c_Id;
	}
	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}
	public String getC_Category() {
		return c_Category;
	}
	public void setC_Category(String c_Category) {
		this.c_Category = c_Category;
	}
	public String getC_Name() {
		return c_Name;
	}
	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}
	
	
}
