package com.as.datasource.apidoc;

import java.util.List;

public class PostManCollection {
	private String name;
	private String description;
	private List<PostManRequestData> requests;

	public String getName() {
		return name;
	}

	public void setName(String collectionName) {
		this.name = collectionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String collectionDescription) {
		this.description = collectionDescription;
	}

	public List<PostManRequestData> getRequests() {
		return requests;
	}

	public void setRequests(List<PostManRequestData> requestList) {
		this.requests = requestList;
	}
}
