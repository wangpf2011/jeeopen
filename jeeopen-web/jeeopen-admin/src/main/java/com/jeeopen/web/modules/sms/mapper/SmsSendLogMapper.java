package com.jeeopen.web.modules.sms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jeeopen.web.modules.sms.entity.SmsSendLog;

import org.apache.ibatis.annotations.Mapper;

/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.sms.mapper
* @title: 发送日志数据库控制层接口
* @description: 发送日志数据库控制层接口
 * @author: wangpf
* @date: 2018-09-14 09:47:53
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Mapper
public interface SmsSendLogMapper extends BaseMapper<SmsSendLog> {

}