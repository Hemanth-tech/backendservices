package constants;

public enum ErrorCodes {

    SERVER_DOWN("SERVER_01", "Server is down"),
    CREATE_POST_FAILED("POST_01", "New post is not created"),
    INCORRECT_USERID("POST_02", "User id is incorrect in newly created post"),
    INCORRECT_TITLE("POST_03", "Title is incorrect in newly created post"),
    INCORRECT_BODY("POST_04", "Body  is incorrect in newly created post");

    private final String code;
    private final String message;

    ErrorCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
