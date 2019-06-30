package com.jeeopen.web.modules.email.task;

import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.web.modules.email.task
 * @title:
 * @description: 邮件任务，主要检查发送失败的
 * @author: wangpf
 * @date: 2018/9/17 16:52
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@Component("emailTask")
public class EmailTask {

    public void run(){
        System.out.println("邮件发送任务！");
    }
}
