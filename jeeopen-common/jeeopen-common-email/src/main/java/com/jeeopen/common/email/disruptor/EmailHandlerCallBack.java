package com.jeeopen.common.email.disruptor;


import com.jeeopen.common.email.data.EmailResult;

public interface EmailHandlerCallBack {
    void onResult(EmailResult emailResult);
}