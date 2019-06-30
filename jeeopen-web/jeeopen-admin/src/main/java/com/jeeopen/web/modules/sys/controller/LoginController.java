package com.jeeopen.web.modules.sys.controller;

import com.jeeopen.web.security.shiro.credential.RetryLimitHashedCredentialsMatcher;
import com.jeeopen.web.security.shiro.exception.RepeatAuthenticationException;
import com.jeeopen.web.security.shiro.filter.authc.FormAuthenticationFilter;
import com.jeeopen.web.security.shiro.realm.UserRealm;
import com.jeeopen.web.utils.LoginLogUtils;
import com.jeeopen.web.utils.UserUtils;
import com.jeeopen.common.mvc.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("${jeeopen.admin.url.prefix}")
public class LoginController extends BaseController {
	@Autowired
	private RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher;

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletRequest response, Model model) {
		// 我的电脑有缓存问题
		UserRealm.Principal principal = UserUtils.getPrincipal(); // 如果已经登录，则跳转到管理首页
		if (principal != null && !principal.isMobileLogin()) {
			return new ModelAndView("redirect:/admin");
		}
		String useruame = WebUtils.getCleanParam(request, FormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
		//boolean rememberMe = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
	//	boolean mobile = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_MOBILE_PARAM);
		String exception = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
	//	String message = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_MESSAGE_ERROR_PARAM);
	//	useruame = "admin";
		// 是否开启验证码
		if (RepeatAuthenticationException.class.getName().equals(exception)
				|| retryLimitHashedCredentialsMatcher.isShowCaptcha(useruame)) { // 重复认证异常加入验证码。
			model.addAttribute("showCaptcha", "1");
		} else {
			model.addAttribute("showCaptcha", "0");
		}

		// 强制登陆跳转
		if (ExcessiveAttemptsException.class.getName().equals(exception)
				|| retryLimitHashedCredentialsMatcher.isForceLogin(useruame)) { // 重复认证异常加入验证码。
			// model.addAttribute("showCaptcha", "1");
		}

		return new ModelAndView("modules/sys/login/login");
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		try {
			Subject subject = SecurityUtils.getSubject();
			if (subject != null && subject.isAuthenticated()) {
				LoginLogUtils.recordLogoutLoginLog(UserUtils.getUser().getUsername(),"退出成功");
				subject.logout();
			}
			return new ModelAndView("modules/sys/login/login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("modules/sys/login/index");
	}

}
