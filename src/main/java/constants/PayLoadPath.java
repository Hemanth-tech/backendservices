package constants;

public enum PayLoadPath {

	CREATE_POST_PAYLOAD("src/test/java/testdata/creatPostPayload.json");


	private final String filePath;

	PayLoadPath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

}