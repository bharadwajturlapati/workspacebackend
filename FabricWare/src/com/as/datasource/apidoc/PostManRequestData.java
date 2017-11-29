package com.as.datasource.apidoc;

import java.util.List;

public class PostManRequestData {
	private List<PostManHeaderData> headerData;
	private String url;
	private String method;
	private String name;
	private String description;
	private String rawModeData;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PostManHeaderData> getHeaderData() {
		return headerData;
	}

	public void setHeaderData(List<PostManHeaderData> headerData) {
		this.headerData = headerData;
	}

	public String getRawModeData() {
		return rawModeData;
	}

	public void setRawModeData(String rawModeData) {
		this.rawModeData = rawModeData;
	}
}
