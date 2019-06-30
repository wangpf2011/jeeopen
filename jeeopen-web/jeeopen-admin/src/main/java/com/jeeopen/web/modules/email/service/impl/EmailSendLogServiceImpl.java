package com.jeeopen.web.modules.email.service.impl;

import com.jeeopen.web.modules.email.entity.EmailSendLog;
import com.jeeopen.web.modules.email.mapper.EmailSendLogMapper;
import com.jeeopen.web.modules.email.service.IEmailSendLogService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.email.service.impl
* @title: 邮件发送日志服务实现
* @description: 邮件发送日志服务实现
 * @author: wangpf
* @date: 2018-09-12 10:58:46
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Transactional
@Service("emailsendlogService")
public class EmailSendLogServiceImpl  extends CommonServiceImpl<EmailSendLogMapper,EmailSendLog> implements  IEmailSendLogService {

}