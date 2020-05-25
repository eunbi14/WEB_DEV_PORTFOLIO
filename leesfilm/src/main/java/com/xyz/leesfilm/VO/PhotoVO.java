package com.xyz.leesfilm.VO;

import org.springframework.stereotype.Component;

@Component
public class PhotoVO {
	private int photoId;
	private String photoAddr;
	private String photoCategory;

	
	public PhotoVO() {
		this.photoAddr = photoAddr;
		this.photoCategory = photoCategory;
		this.photoId = photoId;
	}
	public PhotoVO(String addr, String categ) {
		this.photoAddr=addr;
		this.photoCategory=categ;
	}
	public String getPhotoAddr() {
		return photoAddr;
	}
	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}
	public String getPhotoCategory() {
		return photoCategory;
	}
	public void setPhotoCategory(String photoCategory) {
		this.photoCategory = photoCategory;
	}
	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	
}
