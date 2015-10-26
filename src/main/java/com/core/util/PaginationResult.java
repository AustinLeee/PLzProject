package com.core.util;

import java.util.List;

public class PaginationResult<T> {
	private int page;
	private int records;
	private int total;
	List<T> itemList;

	public PaginationResult(int page, int records, int total, List<T> itemList) {
		this.page = page;
		this.records = records;
		this.total = total;
		this.itemList = itemList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getItemList() {
		return itemList;
	}

	public void setItemList(List<T> itemList) {
		this.itemList = itemList;
	}

}
