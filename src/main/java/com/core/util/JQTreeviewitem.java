package com.core.util;

import java.util.ArrayList;
import java.util.List;

public class JQTreeviewitem {
	private String id = "";
	private String text = "";
	private String url = "";
	private String span_clazz = "";
	private String clazz = "closed";
	private List<JQTreeviewitem> child = new ArrayList<JQTreeviewitem>();

	public JQTreeviewitem(String text) {
		this.text = text;
	}

	public JQTreeviewitem(String text, String url) {
		this.text = text;
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSpan_clazz() {
		return span_clazz;
	}

	public void setSpan_clazz(String span_clazz) {
		this.span_clazz = span_clazz;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void add(JQTreeviewitem item) {
		child.add(item);
	}

	public String getRender() {
		StringBuilder sb = new StringBuilder();
		// <li>
		sb.append("<li");
		if (clazz.length() > 0) {
			sb.append(" class='" + clazz + "'");
		}
		sb.append(">");

		// <span>
		sb.append("<span");
		String tmp_span_clazz = span_clazz;
		if (tmp_span_clazz.length() == 0) {
			tmp_span_clazz = (child.size() > 0) ? "folder" : "file";
		}
		sb.append(" class='" + tmp_span_clazz + "'");
		sb.append(">");
		if (id.length() > 0 || url.length() > 0) {
			sb.append("<a");
			if (id.length() > 0) {
				sb.append(" id='" + id + "'");
			}
			if (url.length() > 0) {
				sb.append(" href='" + url + "'");
			}
			sb.append(">");
		}
		sb.append(text);
		if (id.length() > 0 || url.length() > 0) {
			// <a>
			sb.append("</a>");
		}
		sb.append("</span>");
		if (child.size() > 0) {
			sb.append("\n<ul>");
			for (JQTreeviewitem item : child) {
				sb.append(item.getRender());
			}
			sb.append("</ul>\n");
		}
		sb.append("</li>\n");
		return sb.toString();
	}

}
