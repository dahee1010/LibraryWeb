package com.dto;

import java.sql.Timestamp;

public class QueDto {
	
	int qNum;
	String qId;
	String title;
	String content;
	Timestamp qDate;
	int hit;
	int cnt;
	String open;
	
	public QueDto() {
	}
	
	public QueDto(int qNum, String qId, String title, String content, Timestamp qDate, int hit, int cnt, String open) {
	this.qNum = qNum;
	this.qId = qId;
	this.title = title;
	this.content = content;
	this.qDate = qDate;
	this.hit = hit;
	this.cnt = cnt;
	this.open = open;
	}

	public int getqNum() {
		return qNum;
	}

	public void setqNum(int qNum) {
		this.qNum = qNum;
	}

	public String getqId() {
		return qId;
	}

	public void setqId(String qId) {
		this.qId = qId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getqDate() {
		return qDate;
	}

	public void setqDate(Timestamp qDate) {
		this.qDate = qDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}
}
