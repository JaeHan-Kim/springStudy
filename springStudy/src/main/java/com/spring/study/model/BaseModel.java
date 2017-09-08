package com.spring.study.model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class BaseModel implements Serializable {
	private int page = 1;
	private int totCnt = -1;
	private int listSize = 10;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
}
