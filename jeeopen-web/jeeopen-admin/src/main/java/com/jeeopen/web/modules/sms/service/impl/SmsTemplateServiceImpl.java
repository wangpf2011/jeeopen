package com.jeeopen.web.modules.sms.service.impl;

import com.jeeopen.web.modules.sms.entity.SmsTemplate;
import com.jeeopen.web.modules.sms.mapper.SmsTemplateMapper;
import com.jeeopen.web.modules.sms.service.ISmsTemplateService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.sms.service.impl
* @title: 短信模板服务实现
* @description: 短信模板服务实现
 * @author: wangpf
* @date: 2018-09-14 09:47:35
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Transactional
@Service("smstemplateService")
public class SmsTemplateServiceImpl  extends CommonServiceImpl<SmsTemplateMapper,SmsTemplate> implements  ISmsTemplateService {

}