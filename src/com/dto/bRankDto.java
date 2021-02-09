package com.dto;

public class bRankDto {
	
	int bNum;
	String bName;
	String bWriter;
	String bImg;
	int cnt;
	
	public bRankDto () {
	}
	
	public bRankDto(int bNum, String bName, String bWriter, String bImg , int cnt) {
		this.bNum = bNum;
		this.bName = bName;
		this.bWriter = bWriter;
		this.bImg = bImg;
		this.cnt = cnt;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	
	public String getbImg() {
		return bImg;
	}

	public void setbImg(String bImg) {
		this.bImg = bImg;
	}
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
