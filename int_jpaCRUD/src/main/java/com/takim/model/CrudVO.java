package com.takim.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "jpa_crud_takim")
public class CrudVO implements Serializable {

	/**
	 *  직렬화 받은 뒤 내부에서 자동으로 고유번호를 생성해서 관리 -> 직접선언하고 관리
	 */
	private static final long serialVersionUID = -8278068533735851879L;
	
	// field
	@Column(name = "row_num", updatable = false, insertable = false)
	private long rowNum;
	@Id
	private String idx;
	@Column
	private String subject;
	@Column
	private String content;
	@Column(updatable = false, insertable= false)
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column
	private boolean is_deleted;

	//getter, setter
	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}
	
	public long getRowNum() {
		return rowNum;
	}

	public void setRowNum(long rowNum) {
		this.rowNum = rowNum;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//toString
	@Override
	public String toString() {
		return "CrudVO [rowNum=" + rowNum + ", idx=" + idx + ", subject=" + subject + ", content=" + content + ", date="
				+ date + ", is_deleted=" + is_deleted + "]";
	}
	

}
