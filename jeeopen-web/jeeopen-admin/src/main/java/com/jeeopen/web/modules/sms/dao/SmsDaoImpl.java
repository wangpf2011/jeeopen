package com.jeeopen.web.modules.sms.dao;

import com.jeeopen.web.modules.sms.entity.SmsSendLog;
import com.jeeopen.web.modules.sms.service.ISmsSendLogService;
import com.jeeopen.common.sms.data.SmsResult;
import com.jeeopen.common.sms.disruptor.SmsDao;
import com.jeeopen.common.sms.disruptor.SmsData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 *
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @title: SmsDaoIml.java
 * @package cn.gov.gzst.upms.sms.dao
 * @description: 短信信息返回
 * @author: wangpf
 * @date: 2017年6月8日 上午11:20:04
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
public class SmsDaoImpl implements SmsDao {

    @Autowired
    private ISmsSendLogService smsSendLogService;

    @Override
    public void doResult(String eventId, SmsData smsData, SmsResult smsResult) {
        try {
            SmsSendLog sendLog = smsSendLogService.selectById(eventId);
            sendLog.setMsg(smsResult.getMsg());
            if (smsResult.isSuccess()) {
                sendLog.setStatus(SmsSendLog.SMS_SEND_STATUS_SUCCESS);
            } else {
                sendLog.setStatus(SmsSendLog.SMS_SEND_STATUS_FAIL);
            }
            sendLog.setSmsid(smsResult.getSmsid());
            sendLog.setResponseDate(new Date());
            smsSendLogService.insertOrUpdate(sendLog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}