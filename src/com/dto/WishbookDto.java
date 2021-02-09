package com.dto;

import java.sql.Timestamp;

public class WishbookDto {

	int wbNum;
	String wbName;
	String wbWriter;
	String wbPublish;
	int wbYear;
	Timestamp wbDate;
	
	public WishbookDto() {
	}
	
	public WishbookDto(int wbNum, String wbName, String wbWriter, String wbPublish, int wbYear, Timestamp wbDate) {
		this.wbNum = wbNum;
		this.wbName = wbName;
		this.wbWriter = wbWriter;
		this.wbPublish = wbPublish;
		this.wbYear = wbYear;
		this.wbDate = wbDate;
	}

	public int getWbNum() {
		return wbNum;
	}

	public void setWbNum(int wbNum) {
		this.wbNum = wbNum;
	}

	public String getWbName() {
		return wbName;
	}

	public void setWbName(String wbName) {
		this.wbName = wbName;
	}

	public String getWbWriter() {
		return wbWriter;
	}

	public void setWbWriter(String wbWriter) {
		this.wbWriter = wbWriter;
	}

	public String getWbPublish() {
		return wbPublish;
	}

	public void setWbPublish(String wbPublish) {
		this.wbPublish = wbPublish;
	}
	
	public int getWbYear() {
		return wbYear;
	}

	public void setWbYear(int wbYear) {
		this.wbYear = wbYear;
	}

	public Timestamp getWbDate() {
		return wbDate;
	}

	public void setWbDate(Timestamp wbDate) {
		this.wbDate = wbDate;
	}
}
