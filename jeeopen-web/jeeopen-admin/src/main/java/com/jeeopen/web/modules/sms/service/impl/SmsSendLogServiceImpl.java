package com.jeeopen.web.modules.sms.service.impl;

import com.jeeopen.web.modules.sms.entity.SmsSendLog;
import com.jeeopen.web.modules.sms.mapper.SmsSendLogMapper;
import com.jeeopen.web.modules.sms.service.ISmsSendLogService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.sms.service.impl
* @title: 发送日志服务实现
* @description: 发送日志服务实现
 * @author: wangpf
* @date: 2018-09-14 09:47:53
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Transactional
@Service("smssendlogService")
public class SmsSendLogServiceImpl  extends CommonServiceImpl<SmsSendLogMapper,SmsSendLog> implements  ISmsSendLogService {

}