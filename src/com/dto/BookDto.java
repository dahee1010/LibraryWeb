package com.dto;

public class BookDto {

	int bookNum;
	String bookName;
	String writer;
	String publish;
	int year;
	String code;
	int bCnt;
	int cnt;
	String bookimg;
	
	public BookDto() {
	}
	
	public BookDto(int bookNum, String bookName, String writer, String publish, int year, String code, int bCnt, int cnt, String bookimg) {
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.writer = writer;
		this.publish = publish;
		this.year = year;
		this.code = code;
		this.bCnt = bCnt;
		this.cnt = cnt;
		this.bookimg = bookimg;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getbCnt() {
		return bCnt;
	}

	public void setbCnt(int bCnt) {
		this.bCnt = bCnt;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getBookimg() {
		return bookimg;
	}

	public void setBookimg(String bookimg) {
		this.bookimg = bookimg;
	}
}
