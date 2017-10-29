package com.as.datasource.apidoc;

import java.util.List;

public class PostManCollection {
	private String name;
	private String description;
	private List<PostManRequestData> requests;

	public String getCollectionName() {
		return name;
	}

	public void setCollectionName(String collectionName) {
		this.name = collectionName;
	}

	public String getCollectionDescription() {
		return description;
	}

	public void setCollectionDescription(String collectionDescription) {
		this.description = collectionDescription;
	}

	public List<PostManRequestData> getRequestList() {
		return requests;
	}

	public void setRequestList(List<PostManRequestData> requestList) {
		this.requests = requestList;
	}
}
