package com.jeeopen.common.sms.disruptor;

import java.io.Serializable;

import com.jeeopen.common.sms.data.SmsResult;

public interface SmsHandlerCallBack extends Serializable {
    void onResult(SmsResult smsResult);
}
