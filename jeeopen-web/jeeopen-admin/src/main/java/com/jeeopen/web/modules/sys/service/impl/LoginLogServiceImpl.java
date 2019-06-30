package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.LoginLog;
import com.jeeopen.web.modules.sys.mapper.LoginLogMapper;
import com.jeeopen.web.modules.sys.service.ILoginLogService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.sys.service.impl
* @title: 登陆日志服务实现
* @description: 登陆日志服务实现
* @author: sys
* @date: 2018-09-28 11:31:36
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Transactional
@Service("loginlogService")
public class LoginLogServiceImpl  extends CommonServiceImpl<LoginLogMapper,LoginLog> implements  ILoginLogService {

}