package com.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.SimpleExpression;

public class PaginationQuery {
	private int page = 1;
	private int rows = 20;
	Map<String, List<SimpleExpression>> expressions = new HashMap<String, List<SimpleExpression>>();
	List<Order> order = new ArrayList<Order>();

	public PaginationQuery(int page, int rows) {
		this.page = page;
		this.rows = rows;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Map<String, List<SimpleExpression>> getExpressions() {
		return expressions;
	}

	public void setExpressions(Map<String, List<SimpleExpression>> expressions) {
		this.expressions = expressions;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

}
