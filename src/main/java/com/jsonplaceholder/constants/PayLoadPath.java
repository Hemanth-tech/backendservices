package com.jsonplaceholder.constants;

public enum PayLoadPath {

	CREATE_POST_PAYLOAD("src/test/java/com/jsonplaceholder/testdata/createPostPayload.json"),
	CREATE_COMMENT_PAYLOAD("src/test/java/com/jsonplaceholder/testdata/commentPayload.json");


	private final String filePath;

	PayLoadPath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

}
