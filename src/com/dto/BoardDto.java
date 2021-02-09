package com.dto;

import java.sql.Timestamp;

public class BoardDto {

	int wNum;
	String wId;
	String title;
	String content;
	Timestamp wDate;
	int hit;
	
	public BoardDto() {
	}
	
	public BoardDto(int wNum, String wId, String title, String content, Timestamp wDate, int hit) {
		this.wNum = wNum;
		this.wId = wId;
		this.title = title;
		this.content = content;
		this.wDate = wDate;
		this.hit = hit;
	}

	public int getwNum() {
		return wNum;
	}

	public void setwNum(int wNum) {
		this.wNum = wNum;
	}

	public String getwId() {
		return wId;
	}

	public void setwId(String wId) {
		this.wId = wId;
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

	public Timestamp getwDate() {
		return wDate;
	}

	public void setwDate(Timestamp wDate) {
		this.wDate = wDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
}
