package constants;

public enum ApiResources {
	
	
	post("/posts"),
	comment("/comments"),
	users("/users");
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
