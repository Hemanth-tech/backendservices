package com.jsonplaceholder.constants;

public enum ApiResponse {
    // Successful responses
    SUCCESS(200, "Success"),
    CREATED(201, "Resource created successfully"),

    // Client errors
    BAD_REQUEST(400, "Bad request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not found"),
    METHOD_NOT_ALLOWED(405, "Method not allowed"),
    CONFLICT(409, "Conflict"),

    // Server errors
    INTERNAL_SERVER_ERROR(500, "Internal server error"),
    SERVICE_UNAVAILABLE(503, "Service unavailable");

    private final int code;
    private final String message;

    ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
