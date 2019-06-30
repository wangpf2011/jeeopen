package com.jeeopen.web.modules.email.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jeeopen.web.modules.email.entity.EmailSendLog;

import org.apache.ibatis.annotations.Mapper;

/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.email.mapper
* @title: 邮件发送日志数据库控制层接口
* @description: 邮件发送日志数据库控制层接口
 * @author: wangpf
* @date: 2018-09-12 10:58:46
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Mapper
public interface EmailSendLogMapper extends BaseMapper<EmailSendLog> {

}