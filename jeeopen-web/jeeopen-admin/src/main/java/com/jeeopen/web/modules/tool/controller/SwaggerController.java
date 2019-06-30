package com.jeeopen.web.modules.tool.controller;

import com.jeeopen.common.mvc.annotation.ViewPrefix;
import com.jeeopen.common.mvc.controller.BaseController;
import com.jeeopen.common.security.shiro.authz.annotation.RequiresMethodPermissions;
import com.jeeopen.common.security.shiro.authz.annotation.RequiresPathPermission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("${jeeopen.admin.url.prefix}/tool/swagger")
@ViewPrefix("modules/tool/swagger")
@RequiresPathPermission("tool:swagger")
public class SwaggerController extends BaseController {

	@RequiresMethodPermissions("index")
	@GetMapping
	public ModelAndView index(Model model, HttpServletRequest request, HttpServletResponse response) {
		return displayModelAndView("index");
	}
}
