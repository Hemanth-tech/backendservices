package constants;

public enum Environment {
	

	    QA("https://jsonplaceholder.typicode.com"),DEV("https://jsonplaceholder.typicode.com"),PROD("https://jsonplaceholder.typicode.com/");

	    String env;

	    Environment(String env){
	        this.env = env;
	    }
	    public String getValue() {
			return env;
		}
	

}
