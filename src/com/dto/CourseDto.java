package com.dto;

public class CourseDto {

	int cNum;
	String category;
	String lecName;
	String instruc;
	String object;
	int year;
	int month;
	int day;
	String startTime;
	String endTime;
	int max;
	int applyCnt;
	int state;

	public CourseDto(int cNum, String category, String lecName, String instruc, String object, int year, int month, int day, String startTime, String endTime, int max,
			int applyCnt, int state) {

		this.cNum = cNum;
		this.category = category;
		this.lecName = lecName;
		this.instruc = instruc;
		this.object = object;
		this.year = year;
		this.month = month;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.max = max;
		this.applyCnt = applyCnt;
		this.state = state;
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLecName() {
		return lecName;
	}

	public void setLecName(String lecName) {
		this.lecName = lecName;
	}

	public String getInstruc() {
		return instruc;
	}

	public void setInstruc(String instruc) {
		this.instruc = instruc;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getApplyCnt() {
		return applyCnt;
	}

	public void setApplyCnt(int applyCnt) {
		this.applyCnt = applyCnt;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}	
}
