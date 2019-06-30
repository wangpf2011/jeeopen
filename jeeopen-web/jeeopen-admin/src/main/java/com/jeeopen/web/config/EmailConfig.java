package com.jeeopen.web.config;

import com.jeeopen.web.modules.email.dao.EmailDaoImpl;
import com.jeeopen.common.email.disruptor.EmailDao;
import com.jeeopen.common.email.disruptor.EmailHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @title:
 * @description: 邮件发送配置
 * @author: wangpf
 * @date: 2018/3/1 16:06
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@Configuration
public class EmailConfig {

    @Bean
    public EmailDao emailDao(){
        EmailDao emailDao=  new EmailDaoImpl();
        return emailDao;
    }

    @Bean
    public EmailHelper emailHelper(EmailDao emailDao){
        EmailHelper emailHelper=  new EmailHelper();
        emailHelper.setHandlerCount(1);
        emailHelper.setBufferSize(1024);
        emailHelper.setEmailDao(emailDao);
        return emailHelper;
    }

}
