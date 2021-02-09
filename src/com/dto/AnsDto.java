package com.dto;

import java.sql.Timestamp;

public class AnsDto {
	
	int qNum;
	String qTitle;
	int aNum;
	String content;
	Timestamp aDate;
	
	public AnsDto() {
	}
	
	public AnsDto(int qNume, String qTitle, int aNum, String content, Timestamp aDate) {
		this.qNum = qNume;
		this.qTitle = qTitle;
		this.aNum = aNum;
		this.content = content;
		this.aDate = aDate;
	}

	public int getqNum() {
		return qNum;
	}

	public void setqNum(int qNum) {
		this.qNum = qNum;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public int getaNum() {
		return aNum;
	}

	public void setaNum(int aNum) {
		this.aNum = aNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getaDate() {
		return aDate;
	}

	public void setaDate(Timestamp aDate) {
		this.aDate = aDate;
	}
}
