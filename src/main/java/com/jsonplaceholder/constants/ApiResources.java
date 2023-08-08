package com.jsonplaceholder.constants;

public enum ApiResources {
	
	
	POST("/posts"),
	COMMENT("/posts/{postID}/comments"),
	USERS("/users");
	private String resource;
	
	ApiResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
