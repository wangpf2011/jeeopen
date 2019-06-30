package com.jeeopen.web.beetltags.exception;

public class BeetlTagException extends RuntimeException {
    public BeetlTagException() {
    }
    public BeetlTagException(String msg) {
        super(msg);
    }

    public BeetlTagException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public BeetlTagException(Throwable rootCause) {
        super(rootCause);
    }
}

