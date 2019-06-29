package com.jeeopen.common.oss.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @version V1.0
 * @package com.jeeopen.common.oss.config
 * @title:
 * @description: 阿里云配置
* @author: wangpf
 * @date: 2018/4/26 9:39
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 */
@ConfigurationProperties(prefix = "oss")
public class LocalConfig {
    //外部访问域名
    String  domain="";
    //上传路径
    String uploadFilePath="";

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }

    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }
}
