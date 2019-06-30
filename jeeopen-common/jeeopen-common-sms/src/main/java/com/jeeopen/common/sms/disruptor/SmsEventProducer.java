package com.jeeopen.common.sms.disruptor;

import com.jeeopen.common.sms.config.SmsConfigProperties;
import com.lmax.disruptor.RingBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: LongEventProducer.java
 * @package cn.gov.gzst.sms.common.disruptor.sms
 * @description: 内容生产者
* @author: wangpf
 * @date: 2017年6月7日 下午11:19:15
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
public class SmsEventProducer {
	private static Logger logger = LoggerFactory.getLogger(SmsEventProducer.class);
	private final RingBuffer<SmsEvent> ringBuffer;
	private SmsDao smsDao;

	public SmsEventProducer(RingBuffer<SmsEvent> ringBuffer, SmsDao smsDao) {
		this.ringBuffer = ringBuffer;
		this.smsDao = smsDao;
	}

	private String sendSms(String eventId,SmsData smsData, SmsHandlerCallBack callBack) {
		// 获取下一个序号
		long sequence = ringBuffer.next();
		try {
			// 写入数据
			SmsEvent smsEvent = ringBuffer.get(sequence);
			smsEvent.setId(eventId);
			smsEvent.setSmsData(smsData);
			smsEvent.setHandlerCallBack(callBack);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		} finally {
			// 通知消费者该资源可以消费了
			ringBuffer.publish(sequence);
		}
		return eventId;
	}

	private String sendSms(String eventId,SmsData smsData) {
		return sendSms(eventId,smsData, null);
	}

	public String sendSms(String eventId, String phone, String smsTemplate, SmsConfigProperties smsConfigProperties, Map<String, Object> datas) {
		SmsData smsData = new SmsData();
		smsData.setPhone(phone);
		smsData.setSmsTemplate(smsTemplate);
		smsData.setDatas(datas);
		smsData.setSmsConfigProperties(smsConfigProperties);
		return sendSms(eventId,smsData);
	}

	public String sendSms(String eventId, String phone, String smsTemplate,  SmsConfigProperties smsConfigProperties, Map<String, Object> datas, SmsHandlerCallBack callBack) {
		SmsData smsData = new SmsData();
		smsData.setPhone(phone);
		smsData.setSmsTemplate(smsTemplate);
		smsData.setDatas(datas);
		smsData.setSmsConfigProperties(smsConfigProperties);
		return sendSms(eventId,smsData, callBack);
	}
}