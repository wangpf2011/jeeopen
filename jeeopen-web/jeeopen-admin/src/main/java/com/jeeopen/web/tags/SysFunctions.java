package com.jeeopen.web.tags;

import javax.servlet.http.Cookie;
import com.jeeopen.common.utils.ServletUtils;
import com.jeeopen.common.utils.SpringContextHolder;
import com.jeeopen.common.utils.StringUtils;
import org.springframework.core.env.Environment;

/**
 * 
 * All rights Reserved, Designed By www.jeeopen.com
 * 
 * @title: SysFunctions.java
 * @package com.jeeopen.web.tags
 * @description: 提供一些公用的函数
 * @author: wangpf
 * @date: 2017年3月28日 下午10:04:07
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
public class SysFunctions {

	/**
	 * 获得后台地址
	 * 
	 * @title: getAdminUrlPrefix
	 * @description: 获得后台地址
	 * @return
	 * @return: String
	 */
	public static String getAdminUrlPrefix() {
		Environment env= SpringContextHolder.getBean(Environment.class);
		String adminUrlPrefix = env.getProperty("jeeopen.admin.url.prefix");
		return adminUrlPrefix;
	}

	/**
	 * 加载风格
	 * 
	 * @title: getTheme
	 * @return
	 * @return: String
	 */
	public static String getTheme() {
		// 默认风格
		Environment env= SpringContextHolder.getBean(Environment.class);
		String theme = env.getProperty("jeeopen.admin.default.theme");
		if (StringUtils.isEmpty(theme)) {
			theme = "uadmin";
		}
		// cookies配置中的模版
		Cookie[] cookies = ServletUtils.getRequest().getCookies();
		for (Cookie cookie : cookies) {
			if (cookie == null || StringUtils.isEmpty(cookie.getName())) {
				continue;
			}
			if (cookie.getName().equalsIgnoreCase("theme")) {
				theme = cookie.getValue();
			}
		}
		return theme;
	}
}
