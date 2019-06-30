package com.jeeopen.web.config;

import com.jeeopen.common.disruptor.TaskHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @title:
 * @description: 公用任务配置
 * @author: wangpf
 * @date: 2018/3/1 16:06
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@Configuration
public class TaskConfig {

    @Bean
    public TaskHelper taskHelper(){
        TaskHelper taskHelper=  new TaskHelper();
        taskHelper.setHandlerCount(1);
        taskHelper.setBufferSize(1024);
        return taskHelper;
    }

}
