package com.core.util;

import java.util.ArrayList;

public class JQGridJSON {
	private int page;
	private int total;
	private int records;
	private ArrayList<JQGridRow> rows = new ArrayList<JQGridRow>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public ArrayList<JQGridRow> getRows() {
		return rows;
	}

	public void setRows(ArrayList<JQGridRow> rows) {
		this.rows = rows;
	}

}
