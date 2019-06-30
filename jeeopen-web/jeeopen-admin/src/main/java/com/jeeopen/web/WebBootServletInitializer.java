package com.jeeopen.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.web
 * @title:
 * @description: 启动入口
 * @author: wangpf
 * @date: 2018/8/14 10:25
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
public class WebBootServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebBootApplication.class);
    }
}