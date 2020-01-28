package com.takim.solr.vo;


public class BoardVO {

	private int row_num;
	
	private String idx;
	
	private String subject;
	
	private String content;
	
	private String date;
	
	//검색
	private String keyword;
	private String option;
	

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getRow_num() {
		return row_num;
	}

	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

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

	@Override
	public String toString() {
		return "BoardVO [row_num=" + row_num + ", idx=" + idx + ", subject=" + subject + ", content=" + content
				+ ", date=" + date + "]";
	}


	

	
	
	
	
}
