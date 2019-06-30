package com.jeeopen.web.modules.oa.controller;


import com.jeeopen.web.modules.oa.entity.OaNotification;
import com.jeeopen.common.mvc.annotation.ViewPrefix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeeopen.common.mybatis.mvc.controller.BaseCRUDController;
import com.jeeopen.common.security.shiro.authz.annotation.RequiresPathPermission;

/**   
 * @Title: 通知公告
 * @Description: 通知公告
 * @author wangpf
 * @date 2017-06-10 17:15:17
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${jeeopen.admin.url.prefix}/oa/oanotification")
@ViewPrefix("modules/oa/oanotification")
@RequiresPathPermission("oa:oanotification")
public class OaNotificationController extends BaseCRUDController<OaNotification, String> {

}
