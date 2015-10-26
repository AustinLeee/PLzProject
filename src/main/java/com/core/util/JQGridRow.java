package com.core.util;

import java.util.ArrayList;

public class JQGridRow {
	private String id;
	private ArrayList<String> cell = new ArrayList<String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getCell() {
		return cell;
	}

	public void setCell(ArrayList<String> cell) {
		this.cell = cell;
	}

}
