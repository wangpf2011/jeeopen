package com.jeeopen.common.sms.client;

import java.util.Map;

import com.jeeopen.common.sms.config.SmsConfigProperties;
import com.jeeopen.common.sms.data.SmsResult;

/**
 * All rights Reserved, Designed By kjt.gzst.gov.cn
 *
 * @version V1.0
 * @title: ISmsClient.java
 * @description: 发送短信接口
* @author: wangpf
 * @date: 2018年9月11日 下午9:55:00
 * @copyright: 2017 kjt.gzst.gov.cn Inc. All rights reserved.
 */
public interface ISmsClient {

    /**
     * 客户端初始化
     * @param smsConfigProperties
     */
    void init(SmsConfigProperties smsConfigProperties);

    /**
     *
     *
     * @param phone
     *            手机号码
     * @param template
     *            模版
     * @return
     */
    SmsResult send(String phone, String template);

    /**
     *
     *
     * @param phone
     *            手机号码
     * @param template
     *            模版
     * @param datas
     *            数据
     * @return
     */
     SmsResult send(String phone, String template, Map<String,Object> datas);
}
