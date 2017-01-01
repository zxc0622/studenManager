package com.student.manager.web;

import java.util.List;

public class Page<T> {

	private int pageNo;
	private int pageSize = 3;
	
	private List<T> list;
	
	private int totalNumber;

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	
	public int getPageNo() {
		if(pageNo > getPageCount())
			pageNo = getPageCount();
		if(pageSize < 1)
			pageNo = 1;
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	public int getPageCount(){
		int temp = getTotalNumber() / getPageSize();
		int count = getTotalNumber() % getPageSize() == 0 ? temp : temp + 1;
		return count;
	}
	
	public boolean isHasPre(){
		if(getPageNo() > 1 && getPageCount() > 1){
			return true;
		}
		return false;
	}
	
	public boolean isHasNext(){
		return getPageNo() < getPageCount() ? true : false;
	}
	
	public int getPrePage(){
		if(isHasPre()){
			return pageNo -1;
		}
		return getPageNo();
	}
	
	public int getNextPage(){
		if(isHasNext()){
			return pageNo +1;
		}
		return getPageNo();
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", list=" + list + ", totalNumber=" + totalNumber
				+ "]";
	}
}
