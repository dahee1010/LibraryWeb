package com.dto;

public class ReviewDto {

	int bNum;
	int rNum;
	String rId;
	String rContent;
	int rating;

	public ReviewDto() {
	}

	public ReviewDto(int bNum, int rNum, String rId, String rContent, int rating) {
		this.bNum = bNum;
		this.rNum = rNum;
		this.rId = rId;
		this.rContent = rContent;
		this.rating = rating;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
