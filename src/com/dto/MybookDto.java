package com.dto;

import java.sql.Timestamp;

public class MybookDto {
	
	int bNum;
	int mbNum;
	String mbId;
	String mbName;
	String mbWriter;
	Timestamp mbDate;
	Timestamp mbRdate;
	int exten;
	
	public MybookDto() {
		
	}
	
	public MybookDto(int bNum, int mbNum, String mbId, String mbName, String mbWriter, Timestamp mbDate, Timestamp mbRdate, int exten) {
		this.bNum = bNum;
		this.mbNum = mbNum;
		this.mbId = mbId;
		this.mbName = mbName;
		this.mbWriter = mbWriter;
		this.mbDate = mbDate;
		this.mbRdate = mbRdate;
		this.exten = exten;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public int getMbNum() {
		return mbNum;
	}

	public void setMbNum(int mbNum) {
		this.mbNum = mbNum;
	}

	public String getMbId() {
		return mbId;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public String getMbName() {
		return mbName;
	}

	public void setMbName(String mbName) {
		this.mbName = mbName;
	}

	public String getMbWriter() {
		return mbWriter;
	}

	public void setMbWriter(String mbWriter) {
		this.mbWriter = mbWriter;
	}

	public Timestamp getMbDate() {
		return mbDate;
	}

	public void setMbDate(Timestamp mbDate) {
		this.mbDate = mbDate;
	}

	public Timestamp getMbRdate() {
		return mbRdate;
	}

	public void setMbRdate(Timestamp mbRdate) {
		this.mbRdate = mbRdate;
	}

	public int getExten() {
		return exten;
	}

	public void setExten(int exten) {
		this.exten = exten;
	}
}
