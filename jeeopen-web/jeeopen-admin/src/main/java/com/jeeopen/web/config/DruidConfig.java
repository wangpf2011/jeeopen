package com.jeeopen.web.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 * http://blog.csdn.net/blueheart20/article/details/52384032
 * @version V1.0
 * @package com.jeeopen.web.config
 * @title:
 * @description: DruidConfig
 * @author: wangpf
 * @date: 2018/3/5 15:10
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@Configuration
public class DruidConfig {

        /**
         * 注册一个StatViewServlet
         * @return
         */
        @Bean
        public ServletRegistrationBean druidStatViewServle(){
            //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
            ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/admin/sys/monitor/druid/*");
            //添加初始化参数：initParams
            //白名单：
            //servletRegistrationBean.addInitParameter("allow","127.0.0.1");
            //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
            //servletRegistrationBean.addInitParameter("deny","192.168.1.73");
            //登录查看信息的账号密码.
            //servletRegistrationBean.addInitParameter("loginUsername","admin2");
            //servletRegistrationBean.addInitParameter("loginPassword","123456");
            //是否能够重置数据.
            //servletRegistrationBean.addInitParameter("resetEnable","false");
            return servletRegistrationBean;
        }

        /**
         * 注册一个：filterRegistrationBean
         * @return
         */
        @Bean
        public FilterRegistrationBean druidStatFilter(){

            FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

            //添加过滤规则.
            filterRegistrationBean.addUrlPatterns("/*");

            //添加不需要忽略的格式信息.
            filterRegistrationBean.addInitParameter("exclusions","/static/*,*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
            return filterRegistrationBean;
        }

    }
