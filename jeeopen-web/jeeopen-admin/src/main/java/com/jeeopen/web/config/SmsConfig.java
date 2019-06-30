package com.jeeopen.web.config;

import com.jeeopen.web.modules.sms.dao.SmsDaoImpl;
import com.jeeopen.common.sms.client.AliyunSmsClient;
import com.jeeopen.common.sms.client.ISmsClient;
import com.jeeopen.common.sms.config.SmsConfigProperties;
import com.jeeopen.common.sms.disruptor.SmsDao;
import com.jeeopen.common.sms.disruptor.SmsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @title:
 * @description: 短信发送配置
 * @author: wangpf
 * @date: 2018/3/1 16:06
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@Configuration
@EnableConfigurationProperties({SmsConfigProperties.class})
public class SmsConfig {
    @Autowired
    private SmsConfigProperties smsConfigProperties;

    @Bean
    public SmsDao smsDao(){
        SmsDao smsDao=  new SmsDaoImpl();
        return smsDao;
    }
    @Bean
    public ISmsClient smsClient(){
        ISmsClient smsClient=  new AliyunSmsClient();
        smsClient.init(smsConfigProperties);
        return smsClient;
    }

    @Bean
    public SmsHelper smsHelper(ISmsClient smsClient,SmsDao smsDao){
        SmsHelper smsHelper=  new SmsHelper();
        smsHelper.setHandlerCount(1);
        smsHelper.setBufferSize(1024);
        smsHelper.setSmsClient(smsClient);
        smsHelper.setSmsDao(smsDao);
        return smsHelper;
    }

}
