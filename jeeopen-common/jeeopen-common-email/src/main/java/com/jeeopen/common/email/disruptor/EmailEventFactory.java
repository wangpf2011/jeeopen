package com.jeeopen.common.email.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: LongEventFactory.java
 * @package cn.gov.gzst.common.disruptor.sms
 * @description: 定义事件工厂
 * @author: wangpf
 * @date: 2017年6月7日 下午11:18:32
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
public class EmailEventFactory implements EventFactory<EmailEvent> {
	public EmailEvent newInstance() {
		return new EmailEvent();
	}
}