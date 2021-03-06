package com.jeeopen.web.modules.email.service.impl;

import com.jeeopen.web.modules.email.entity.EmailTemplate;
import com.jeeopen.web.modules.email.mapper.EmailTemplateMapper;
import com.jeeopen.web.modules.email.service.IEmailTemplateService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.email.service.impl
* @title: 邮件模板服务实现
* @description: 邮件模板服务实现
 * @author: wangpf
* @date: 2018-09-12 10:59:18
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Transactional
@Service("emailtemplateService")
public class EmailTemplateServiceImpl  extends CommonServiceImpl<EmailTemplateMapper,EmailTemplate> implements  IEmailTemplateService {

}