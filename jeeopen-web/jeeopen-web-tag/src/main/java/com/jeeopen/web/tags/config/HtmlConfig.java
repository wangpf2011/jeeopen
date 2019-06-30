package com.jeeopen.web.tags.config;

import com.jeeopen.web.tags.html.builder.DefaultHtmlComponentBuilder;
import com.jeeopen.web.tags.html.manager.HtmlComponentManager;
import com.jeeopen.common.utils.SpringContextHolder;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.modules.config
 * @title:
 * @description: HTML初始化
* @author: wangpf
 * @date: 2018/3/3 15:06
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@Configuration
public class HtmlConfig implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments var1) throws Exception {
        SpringContextHolder.getApplicationContext()
                .getBean(HtmlComponentManager.class).init();
    }
    /**
     * HTML 组建加载器
     * @return
     */
    @Bean
    public DefaultHtmlComponentBuilder defaultHtmlComponentBuilder(){
        DefaultHtmlComponentBuilder defaultHtmlComponentBuilder=new DefaultHtmlComponentBuilder();
        defaultHtmlComponentBuilder.setFileNames(new String[]{"classpath:/tagmapper/*-html-component.xml"});
        return defaultHtmlComponentBuilder;
    }

    @Bean
    public HtmlComponentManager htmlComponentManager( DefaultHtmlComponentBuilder defaultHtmlComponentBuilder){
        HtmlComponentManager htmlComponentManager=new HtmlComponentManager();
        htmlComponentManager.setDynamicStatementBuilder(defaultHtmlComponentBuilder);
        return htmlComponentManager;
    }
}
