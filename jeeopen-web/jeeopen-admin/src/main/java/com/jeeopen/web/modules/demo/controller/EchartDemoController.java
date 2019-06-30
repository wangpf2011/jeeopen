package com.jeeopen.web.modules.demo.controller;

import com.jeeopen.common.mvc.annotation.ViewPrefix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeeopen.common.mvc.controller.BaseController;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: FormDemoController.java
 * @package com.jeeopen.web.modules.demo.controller
 * @description: 统计报表DEMO
 * @author: wangpf
 * @date: 2017年5月18日 下午6:17:24
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */

@Controller
@RequestMapping("${jeeopen.admin.url.prefix}/demo/echart")
@ViewPrefix("modules/demo/echart")
public class EchartDemoController extends BaseController {

	/**
	 * 
	 * @title: echart   
	 * @description: 统计 
	 * @return      
	 * @return: String
	 */
	@RequestMapping("/index")
	public String echart() {
		return display("index");
	}
 
}
