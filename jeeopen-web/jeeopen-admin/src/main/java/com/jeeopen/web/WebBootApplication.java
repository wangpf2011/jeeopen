package com.jeeopen.web;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.web
 * @title: Web启动入口
 * @description: Web启动入口
 * @author: wangpf
 * @date: 2018/5/22 14:56
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@EnableSwagger2Doc
@EnableSwagger2
@ComponentScan({"com.jeeopen.common.quartz.config","com.jeeopen.common.oss","com.jeeopen.common.sms","com.jeeopen.web.tags","com.jeeopen.ui","com.jeeopen.web.beetltags","com.jeeopen.web"})
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
// @SpringBootApplication
public class WebBootApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebBootApplication.class, args);
    }
}

