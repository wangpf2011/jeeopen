package com.jeeopen.web.modules.demo.controller;


import com.jeeopen.common.mvc.annotation.ViewPrefix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeeopen.common.mvc.controller.BaseController;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: GridDemoController.java
 * @package com.jeeopen.web.modules.demo.controller
 * @description: GridDemo
 * @author: wangpf
 * @date: 2017年5月18日 下午6:17:24
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */

@Controller
@RequestMapping("${jeeopen.admin.url.prefix}/demo/grid")
@ViewPrefix("modules/demo/grid")
public class GridDemoController extends BaseController {

	/**
	 * 
	 * @title: list
	 * @description: 列表
	 * @return
	 * @return: String
	 */
	@RequestMapping("/list")
	public String list() {
		return display("list");
	}
	/**
	 * 
	 * @title: list
	 * @description: 列表
	 * @return
	 * @return: String
	 */
	@RequestMapping("/list_inline")
	public String listLline() {
		return display("list-inline");
	}

	 

}
