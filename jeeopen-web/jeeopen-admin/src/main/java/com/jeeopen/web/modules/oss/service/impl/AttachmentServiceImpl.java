package com.jeeopen.web.modules.oss.service.impl;

import com.jeeopen.web.modules.oss.entity.Attachment;
import com.jeeopen.web.modules.oss.mapper.AttachmentMapper;
import com.jeeopen.web.modules.oss.service.IAttachmentService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.jeeopen.com
*
* @version V1.0
* @package cn.gov.gzst.oss.service.impl
* @title: 附件管理服务实现
* @description: 附件管理服务实现
 * @author: wangpf
* @date: 2018-04-25 14:25:54
* @copyright: 2018 www.jeeopen.com Inc. All rights reserved.
*/
@Transactional
@Service("attachmentService")
public class AttachmentServiceImpl  extends CommonServiceImpl<AttachmentMapper,Attachment> implements IAttachmentService {

}