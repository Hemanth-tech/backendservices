package com.jsonplaceholder.constants;

public enum ErrorCodes {

    SERVER_DOWN("SERVER_01", "Server is down"),
    
    
    //POST END POINT ERROR CODES
    POST_ENDPOINT_IS_DOWN("POST_00", "Creat post endpoint is down"),
    CREATE_POST_FAILED("POST_01", "New post is not created"),
    INCORRECT_USERID("POST_02", "User id is incorrect in post response body"),
    INCORRECT_TITLE("POST_03", "Title is incorrect in post response body"),
    INCORRECT_BODY("POST_04", "Body  is incorrect in post response body"),
    CREATE_POST_FOR_INVALID_USERID_FAILED("POST_05", "Create post failed for invalid user id"),
    RETRIVE_POST_BY_USERID_FAILED("POST_06", "Couldn't retrive post using user ID"),
    UPDATE_POST_BY_USERID_FAILED("POST_07", "Update post by user id failed"),
    DELETE_POST_BY_USERID_FAILED("POST_08", "Delete post by user id failed"),
    DELETE_POST_BY_POSTID_FAILED("POST_08", "Delete post by post id failed"),
	UPDATE_DELETED_POST("POST_09", "Deleted post cannot be updated"),
	
	//COMMENT END POINT ERROR CODES
    COMMENT_ENDPOINT_IS_DOWN("COMMENT_00", "Comment post endpoint is down"),
    RETRIVE_COMMENT_BY_POSTID_FAILED("COMMENT_01", "Couldn't retrive comment using user post ID"),
	UPDATE_COMMENT_FAILED("COMMENT_03","Update comment failed"),
	DELETE_COMMENT_FAILED("COMMENT_03","Delete comment failed"),
	CREATE_COMMENT_FAILED("COMMENT_03","Create comment failed"),
	
	//User endpoint error codes
	USER_ENDPOINT_IS_DOWN("COMMENT_00", "Comment post endpoint is down"),
    RETRIVE_USER__FAILED("USER_01", "Couldn't retrive comment using user post ID"),
	UPDATE_USER_FAILED("USER_03","Update user failed"),
	DELETE_USER_FAILED("USER_03","Delete user failed"),
	CREATE_USER_FAILED("USER_03","Create user failed");
	






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
