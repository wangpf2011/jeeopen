package com.jeeopen.web.modules.oss.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jeeopen.web.modules.oss.entity.Attachment;

import org.apache.ibatis.annotations.Mapper;

/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package cn.gov.gzst.oss.mapper
* @title: 附件管理数据库控制层接口
* @description: 附件管理数据库控制层接口
 * @author: wangpf
* @date: 2018-04-25 14:25:54
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Mapper
public interface AttachmentMapper extends BaseMapper<Attachment> {

}