package com.jeeopen.web.modules.oa.service.impl;

import com.jeeopen.web.modules.oa.entity.OaNotification;
import com.jeeopen.web.modules.oa.mapper.OaNotificationMapper;
import com.jeeopen.web.modules.oa.service.IOaNotificationService;
import com.jeeopen.common.mybatis.mvc.service.impl.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 通知公告
 * @Description: 通知公告
 * @author wangpf
 * @date 2017-06-10 17:15:17
 * @version V1.0   
 *
 */
@Transactional
@Service("oaNotificationService")
public class OaNotificationServiceImpl  extends CommonServiceImpl<OaNotificationMapper,OaNotification> implements  IOaNotificationService {

}
