package com.jeeopen.web.modules.sms.service.impl;

import com.jeeopen.web.modules.sms.entity.SmsSendLog;
import com.jeeopen.web.modules.sms.entity.SmsTemplate;
import com.jeeopen.web.modules.sms.service.ISmsSendLogService;
import com.jeeopen.web.modules.sms.service.ISmsSendService;
import com.jeeopen.web.modules.sms.service.ISmsTemplateService;
import com.jeeopen.common.mybatis.mvc.wrapper.EntityWrapper;
import com.jeeopen.common.sms.disruptor.SmsHelper;
import com.jeeopen.common.utils.mapper.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.web.modules.sms.service.impl
 * @title:
 * @description: 短信发送
 * @author: wangpf
 * @date: 2018/9/12 11:15
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@Service("smsSendService")
public class SmsSendServiceImpl implements ISmsSendService {

	@Autowired
	private ISmsTemplateService smsTemplateService;
	@Autowired
	private ISmsSendLogService smsSendLogService;
	@Autowired
	private SmsHelper smsHelper; //自动注入的Bean

	@Override
	@Transactional(propagation= Propagation.NOT_SUPPORTED)
	public void send(String phone, String code, Map<String, Object> datas) {
		String[] phones = { phone };
		send(phones,code,datas);
	}

	@Override
	@Transactional(propagation= Propagation.NOT_SUPPORTED)
	public void send(String[] phones, String code, Map<String, Object> datas) {
		SmsTemplate template = smsTemplateService.selectOne(new EntityWrapper<SmsTemplate>().eq("code", code));
		if (datas == null) {
			datas = new HashMap<>();
		}
		if (template == null){
			return ;
		}
		for (String phone: phones) {
			SmsSendLog smsSendLog = new SmsSendLog();
			smsSendLog.setPhone(phone);
			smsSendLog.setTemplateName(template.getName());
			smsSendLog.setMsg("发送成功");
			smsSendLog.setSendCode(code);
			smsSendLog.setResponseDate(new Date());
			smsSendLog.setSendData(JsonMapper.toJsonString(datas));
			smsSendLog.setStatus(SmsSendLog.SMS_SEND_STATUS_IN);
			smsSendLog.setTryNum(0);
			smsSendLog.setDelFlag("0");
			smsSendLogService.insert(smsSendLog);
			// 发送邮件,这里以后需要判断类型
			smsHelper.sendAsyncSms(smsSendLog.getId(),phone,template.getTemplateContent(),null,datas);
		}
	}
}