package com.jeeopen.web.modules.email.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jeeopen.web.modules.email.entity.EmailTemplate;

import org.apache.ibatis.annotations.Mapper;

/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package com.jeeopen.web.modules.email.mapper
* @title: 邮件模板数据库控制层接口
* @description: 邮件模板数据库控制层接口
 * @author: wangpf
* @date: 2018-09-12 10:59:18
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Mapper
public interface EmailTemplateMapper extends BaseMapper<EmailTemplate> {

}