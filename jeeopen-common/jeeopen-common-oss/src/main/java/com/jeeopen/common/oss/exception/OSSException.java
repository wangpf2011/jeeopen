package com.jeeopen.common.oss.exception;

/**
 * OSS异常
 * Created by wangpf on 2017/8/11.
 */
public class OSSException extends RuntimeException {

    public OSSException() {
        super();
    }


    public OSSException(String message) {
        super(message);
    }

    public OSSException(String message, Throwable cause) {
        super(message, cause);
    }


    public OSSException(Throwable cause) {
        super(cause);
    }


    protected OSSException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
