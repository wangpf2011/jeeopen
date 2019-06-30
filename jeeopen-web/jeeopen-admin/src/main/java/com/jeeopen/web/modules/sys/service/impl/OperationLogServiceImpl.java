package com.jeeopen.web.modules.sys.service.impl;

import com.jeeopen.web.modules.sys.entity.OperationLog;
import com.jeeopen.web.modules.sys.mapper.OperationLogMapper;
import com.jeeopen.web.modules.sys.service.IOperationLogService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.sys.service.impl
* @title: 操作日志服务实现
* @description: 操作日志服务实现
 * @author: wangpf
* @date: 2018-09-30 15:53:25
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Transactional
@Service("operationlogService")
public class OperationLogServiceImpl  extends CommonServiceImpl<OperationLogMapper,OperationLog> implements  IOperationLogService {

}