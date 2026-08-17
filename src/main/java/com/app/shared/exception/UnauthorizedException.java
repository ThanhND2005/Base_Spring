package com.app.shared.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception thrown when user is not authorized or token is invalid.
 */
public class UnauthorizedException extends AppException {

    public UnauthorizedException(String message) {
        super(ErrorCode.UNAUTHENTICATED, message);
    }

    public UnauthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
