package com.jeeopen.common.sms.config;

import com.jeeopen.common.utils.PropertiesUtil;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.common.oss.config
 * @title:
 * @description: 互易配置
* @author: wangpf
 * @date: 2018/4/26 9:39
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
public class HuyiConfigProperties {
    public static final String DEFAULT_CONFIG_FILE = "huyi.sms.properties";
    //应用ID
    private  String accountApiId="";
    //密钥
    private  String accountApiKey="";


    public static SmsConfigProperties init() {
        return buildConfigProperties(DEFAULT_CONFIG_FILE);
    }

    public static SmsConfigProperties buildConfigProperties(String propertiesName) {
        PropertiesUtil p = new PropertiesUtil(propertiesName);
        SmsConfigProperties smsConfigProperties = new SmsConfigProperties();
        smsConfigProperties.setOpen(p.getBoolean("sms.open"));
        smsConfigProperties.setSignName(p.getString("sms.sign-name"));
        HuyiConfigProperties huyiConfig = new HuyiConfigProperties();
        huyiConfig.setAccountApiId(p.getString("sms.huyi.account-api-id"));
        huyiConfig.setAccountApiKey(p.getString("sms.huyi.account-api-key"));
        smsConfigProperties.setHuyi(huyiConfig);
        return smsConfigProperties;
    }

    public String getAccountApiId() {
        return accountApiId;
    }

    public void setAccountApiId(String accountApiId) {
        this.accountApiId = accountApiId;
    }

    public String getAccountApiKey() {
        return accountApiKey;
    }

    public void setAccountApiKey(String accountApiKey) {
        this.accountApiKey = accountApiKey;
    }
}
