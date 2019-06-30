package com.jeeopen.common.email.disruptor;

import com.jeeopen.common.email.data.EmailResult;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: SmsDao.java
 * @package cn.gov.gzst.common.disruptor.sms
 * @description: 短信dao
 * @author: wangpf
 * @date: 2017年6月8日 上午8:42:47
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 * 
 */
public interface EmailDao {

	/**
	 * 
	 * @title: doResult
	 * @description:响应
	 * @return: void
	 */
	public void doResult(String eventId, EmailData emailData, EmailResult emailResult);
}