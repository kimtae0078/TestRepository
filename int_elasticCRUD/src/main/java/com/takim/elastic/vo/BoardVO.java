package com.takim.elastic.vo;


public class BoardVO {

	private String subject;
	
	private String content;
	
	private String date;
	
	private String idx;
	
	private int rowNum;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	@Override
	public String toString() {
		return "BoardVO [subject=" + subject + ", content=" + content + ", date=" + date + ", idx=" + idx + ", rowNum="
				+ rowNum + "]";
	}

	
	
	
	
}
