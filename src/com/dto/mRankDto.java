package com.dto;

public class mRankDto {

	String id;
	int cnt;

	public mRankDto() {
	}

	public mRankDto(String id, int cnt) {
		this.id = id;
		this.cnt = cnt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
